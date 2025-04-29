(ns exercism.033-anagram
  (:require [clojure.string :as s]))

;; source: https://exercism.org/tracks/clojure/exercises/anagram

(defn- anagrams? [word candidate]
  (let [w-l (s/lower-case word)
        c-l (s/lower-case candidate)]
    (and (not= w-l c-l) (= (sort w-l) (sort c-l)))))

(defn anagrams-for [word prospect-list]
  (filter (partial anagrams? word) prospect-list))

(comment
  (anagrams-for "solemn" ["lemons" "cherry" "melons"])
  )