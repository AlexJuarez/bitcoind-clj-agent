(ns notify.schema
  (:use [lobos.core :only (defcommand migrate)])
  (:require
   [notify.db :as db]
   [lobos.migration :as lm]))

(defcommand pending-migrations []
  (lm/pending-migrations db/db-spec sname))

(defn actualized?
    "checks if there are no pending migrations"
    []
    (empty? (pending-migrations)))

(def actualize migrate)
