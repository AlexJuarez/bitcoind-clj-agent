(ns notify.core
  (:use notify.db
        environ.core)
  (:gen-class :main true))

(defn -main [& args]
  (println (env :db-user))
  (println args))
