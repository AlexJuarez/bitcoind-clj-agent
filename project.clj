(defproject notify "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :repl-options
  {:init-ns notify.core}
  :main notify.core
  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [com.taoensso/timbre "3.1.4"];;logging
   [postgresql/postgresql "9.1-901.jdbc4"]
   [korma "0.3.2"];;dbl
   [org.clojure/java.jdbc "0.3.3"]
   [environ "0.4.0"]]
  :profiles
  {:user
   {:env {:db-user "warden"
          :db-password "admin"}}
   :uberjar
   {:aot :all}}
  :plugins
  [[lein-environ "0.5.0"]])
