(ns notify.core
  (:use [notify.db]
        [compojure.core :only [defroutes GET]]
        [korma.core]
        [taoensso.timbre :refer [trace debug info warn error fatal]]
        [org.httpkit.server])
  (:gen-class :main true))

(defn create-transaction [tx]
  (try
    (insert transactions (values {:id tx}))
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
  (run-server all-routes {:port 8090}))
