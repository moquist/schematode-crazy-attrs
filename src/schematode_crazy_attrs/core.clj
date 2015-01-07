(ns schematode-crazy-attrs.core
  (:require [datomic.api :as d]
            [datomic-schematode :as dst]
            [clojure.pprint :refer [pprint]]))

(def schema
  [{:namespace :gandalf
    :attrs [[:on-head :hat]
            [:on-chin :beard]
            [:in-hand :wizard-staff]]}])

(def schema-expanded
  (first (dst/schematize schema d/tempid)))

(def db-url "datomic:mem://schematode-crazzy-attrs")
(d/create-database db-url)

(defn demo []
  (def tx-futures (dst/load-schema! (d/connect db-url) schema))

  (println "
          ;; -------------------------------------
          ;; No exception seen yet... but deref each future in schema-load now.
          ;; -------------------------------------")

  (try
    (doall (map deref tx-futures))
    (catch java.util.concurrent.ExecutionException e
      (println "
          ;; -------------------------------------
          ;; Caught the exception... rethrowing.
          ;; -------------------------------------")
      (throw e))))
