(ns notify.core
  (:use notify.db
        environ.core
        korma.core)
  (:gen-class :main true))


(defn create-transaction [tx]
  (insert transactions (values {:id tx})))

(defn create-block [id]
  (insert blocks (values {:id id})))

(defn -main [& args]
  (if (some #{"-block"} args)
    (create-block (last args))
    (create-transaction (last args))))
