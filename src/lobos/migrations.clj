(ns lobos.migrations
  (:refer-clojure
     :exclude [alter drop bigint boolean char double float time])
       (:use (lobos [migration :only [defmigration]] core schema config helpers)))

(defmigration add-transactions-table
  (up [] (create
          (tbl :transaction
               (boolean :processed (default false))
               (varchar :id 64))))
  (down [] (drop (table :transaction))))

(defmigration add-blocks-table
  (up [] (create
          (tbl :block
               (boolean :processed (default false))
               (varchar :id 64))))
  (down [] (drop (table :block))))
