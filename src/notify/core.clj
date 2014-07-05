(ns notify.core
  (:use [notify.db]
        [compojure.core :only [defroutes GET]]
        [korma.core]
        [taoensso.timbre :as timbre :refer [trace debug info warn error fatal]]
        [com.postspectacular.rotor :as rotor]
        [org.httpkit.server]
        [notify.schema])
  (:require [notify.schema :as schema])
  (:gen-class :main true))

(defn create-transaction [tx]
  (try
    (if-not (empty? (select transactions (where {:id tx})))
      (update transactions (set-fields {:updated_on (raw "now()")}))
      (insert transactions (values {:id tx})))
    (catch Exception ex
      (error ex))))

(defn create-block [id]
  (try
    (insert blocks (values {:id id}))
    (catch Exception ex
      (error ex))))

(defroutes all-routes
  (GET "/transaction/:id" [id] (create-transaction id))
  (GET "/block/:id" [id] (create-block id)))

(defn -main []
  (if-not (schema/actualized?) (schema/actualize))

  (timbre/set-config!
   [:appenders :rotor]
   {:min-level :info
    :enabled? true
    :async? false ; should be always false for rotor
    :max-message-per-msecs nil
    :fn rotor/append})

  (timbre/set-config!
   [:shared-appender-config :rotor]
   {:path "notify.log" :max-size (* 512 1024) :backlog 10})

  (run-server all-routes {:port 8090}))
