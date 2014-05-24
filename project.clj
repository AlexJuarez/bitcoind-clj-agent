(defproject notify "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :repl-options
  {:init-ns notify.core}
  :main notify.core
  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [com.taoensso/timbre "3.1.4"];;logging
   [org.clojure/java.jdbc "0.2.3"];;dependency for korma
   [korma "0.3.0-beta11"];;dbl
   [environ "0.4.0"]

   ])
