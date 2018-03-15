(use 'dividend.eligibility)
(use 'clojure.test)

(Given #"^I have street \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\"$" [street, city, state, zip]
       (reset! request-data {:street street
                             :city city
                             :state state
                             :zip zip}))

(When #"I check eligibility" []
      (let [rsp (eligibility @request-data)]
         (reset! response-json rsp)))

(Then #"^I am eligible for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$" [emp cu pace]
      (assert (= false (get-in @response-json ["allowed-to-add-project"])))
      (assert (not (nil? (get-in @response-json ["product-availability"]))))
      (let [empower-node (first (get-in @response-json ["product-availability"]))
            cu-node (second (get-in @response-json ["product-availability"]))
            pace-node (last (get-in @response-json ["product-availability"]))
            _ (assert (= (get-in empower-node ["status"]) emp))
            _ (assert (= (get-in cu-node ["status"]) cu))
            _ (assert (= (get-in pace-node ["status"]) pace))]))

(Given #"^I have a table with its keys in a header row:$" [data]
       (println "rows are " (table->rows data))
       (reset! request-data (table->rows data))
       )

(When #"I check loop eligibility" []
      (println "IN LOOP ELigibility")
      (let [some-fn (fn [req] {:req req :res (eligibility req)}
                      )
            all-results (map some-fn @request-data)
            ;_ (println "All results " all-results)
            _ (reset! response-json all-results) 
            _ (println "All results " @response-json)
            ]
        )
      )

(defn assert-stuff
  [x]
  (let [req (:req x)
        res (:res x)]
    (assert (= false (get-in res ["allowed-to-add-project"])))
    (assert (not (nil? (get-in res ["product-availability"]))))
    (let [empower-node (first (get-in res ["product-availability"]))
          cu-node (second (get-in res ["product-availability"]))
          pace-node (last (get-in res ["product-availability"]))
          _ (assert (= (get-in empower-node ["status"]) (get-in req [:emp])))
          _ (assert (= (get-in empower-node ["status"]) (get-in req [:cu])))
          _ (assert (= (get-in empower-node ["status"]) (get-in req [:pace])))
          ]
      )
    )
  )

(Then #"^Am I eligible" []
      (map assert-stuff @response-json)
        )

