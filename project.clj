(defproject notify "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :repl-options
  {:init-ns notify.core}
  :main notify.core
  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [com.postspectacular/rotor "0.1.0"];;logging
   [com.taoensso/timbre "3.1.4"];;logging
   [org.clojure/java.jdbc "0.2.3"];;dependency for korma
   [postgresql/postgresql "9.1-901.jdbc4"]
   [korma "0.3.0-beta11"]
   [lobos "1.0.0-beta1"]
   [compojure "1.1.6"]
   [http-kit "2.1.16"]
   [environ "0.4.0"]]
  :profiles
  {:user
   {:env {:db-user "warden"
          :db-password "admin"}}
   :uberjar
   {:aot :all}}
  :plugins
  [[lein-environ "0.5.0"]])
