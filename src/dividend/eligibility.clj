(ns dividend.eligibility
  (:require
   [clj-http.client :as http]
   [environ.core :refer [env]]
   [clojure.data.json :as json]))

(def request-data (atom nil))
(def response-json (atom nil))

(defn eligibility
  [req]
  (let [_ (println "Calling eligibility")
  resp (http/get (env :url)
                 {:headers {:authorization (env :bubble-auth-token)}
             :query-params {"street1" (:street req)
                            "city" (:city req)
                            "state" (:state req)
                            "zip" (:zip req)
                            "installer-id" "x"
                            }
             :as :auto
             :debug false
             })]
    (json/read-str (:body resp))
    ))
