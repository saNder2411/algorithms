(ns exercism.acronym
  (:require [clojure.string :as str]))

;; source: https://exercism.org/tracks/clojure/exercises/acronym

(defn acronym [phrase]
  (let [words (-> phrase
                  (clojure.string/replace #"-" " ")
                  (clojure.string/replace #"_" " ")
                  (clojure.string/split #" "))]
    (apply str (map #(clojure.string/upper-case (if (empty? %) "" (first %))) words))))

(comment
  (acronym "First In, First Out")
  (acronym "The Road _Not_ Taken")
  )