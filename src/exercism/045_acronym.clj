(ns exercism.045-acronym
  (:require [clojure.string :as s]))

;; source: https://exercism.org/tracks/clojure/exercises/acronym

(defn acronym [phrase]
  (let [words (-> phrase
                  (s/replace #"-" " ")
                  (s/replace #"_" " ")
                  (s/split #" "))]
    (apply str (map #(s/upper-case (if (empty? %) "" (first %))) words))))

(comment
  (acronym "First In, First Out")
  (acronym "The Road _Not_ Taken")
  )