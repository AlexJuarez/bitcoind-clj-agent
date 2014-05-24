(ns notify.db
  (:use [korma.core]
        [korma.db :only (defdb)]
        [korma.core]
        [environ.core]
        ))

(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/wallets"
   :user (env :db-user)
   :password (env :db-password)})

(defdb db db-spec)

(declare transactions blocks)
