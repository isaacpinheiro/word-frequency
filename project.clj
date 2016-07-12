(defproject word-frequency "0.1.0-SNAPSHOT"
  :description "Example with Clojure."
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot word-frequency.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
