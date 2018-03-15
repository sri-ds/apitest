(defproject apitest "1.0.X"
  :description "A demo of Cucumber with Clojure and Leiningen"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [cider/cider-nrepl "0.14.0"]
                 [luminus-immutant "0.2.2"]
                 [luminus-migrations "0.2.8"]
                 [luminus-nrepl "0.1.4"]
                 [mount "0.1.10"]
                 [com.cemerick/url "0.1.1"]
                 [info.cukes/cucumber-clojure "1.2.5" :scope "test"]
                 [environ "1.1.0"]
                 [clj-http "3.6.1"]
                 [com.cemerick/piggieback "0.2.2-SNAPSHOT"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/data.zip "0.1.2"]
                 [org.clojure/data.xml "0.0.8"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/core.cache "0.6.5"]
                 [org.slf4j/log4j-over-slf4j "1.7.25"]
                 [org.slf4j/jcl-over-slf4j "1.7.25"]
                 [org.slf4j/jul-to-slf4j "1.7.25"]

                 ]
  :plugins [[com.siili/lein-cucumber "1.0.7"]]
  :cucumber-feature-paths ["test/features/"]
  :profiles
  {:dev
   {:dependencies [[com.siili/lein-cucumber "1.0.7"]]}}
)
