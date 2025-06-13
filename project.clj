(defproject recur "0.1.0-SNAPSHOT"
  :description "Recur API"
  :url "https://recur-app.com/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [ring/ring-core "1.14.1"]
                 [ring/ring-jetty-adapter "1.14.1"]
                 [ring-cors "0.1.13"]
                 [ring/ring-json "0.5.1"]
                 [compojure "1.7.1"]]
  :main ^:skip-aot recur.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
