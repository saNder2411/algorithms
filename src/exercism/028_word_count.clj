(ns exercism.028-word-count
  (:require [clojure.string :as string]))

; source: https://exercism.org/tracks/clojure/exercises/word-count

(defn word-count [s]
  (->> s
       string/lower-case
       (re-seq #"\b\w+'?\w*\b")
       frequencies))

(comment
  (word-count "word")
  (word-count "one of each")
  (word-count "one fish two fish red fish blue fish")
  (word-count "one,two,three")
  (word-count "one,\ntwo,\nthree")
  (word-count "car: carpet as java: javascript!!&@$%^&")
  (word-count "testing, 1, 2 testing")
  (word-count "go Go GO Stop stop")
  (word-count "'First: don't laugh. Then: don't cry. You're getting it.'")
  (word-count "Joe can't tell between 'large' and large.")
  (word-count "Joe can't tell between app, apple and a.")
  (word-count " multiple   whitespaces")
  (word-count ",\n,one,\n ,two \n 'three'")
  (word-count "can, can't, 'can't'")
  )