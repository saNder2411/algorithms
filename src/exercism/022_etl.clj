(ns exercism.022-etl
  (:require [clojure.string :refer [lower-case]]))

;; source: https://exercism.org/tracks/clojure/exercises/etl

(defn transform [source]
  (reduce (fn [acc [k v]]
            (apply assoc acc (mapcat #(vec [(lower-case %) k]) v))) {} source))

(defn transform-1 [source]
  (into {} (for [[score letters] source
                 letter letters]
             [(lower-case letter) score])))

(comment
  (time (transform {1  ["A" "E" "I" "O" "U" "L" "N" "R" "S" "T"]
                    2  ["D" "G"]
                    3  ["B" "C" "M" "P"]
                    4  ["F" "H" "V" "W" "Y"]
                    5  ["K"]
                    8  ["J" "X"]
                    10 ["Q" "Z"]}))

  (time (transform-1 {1  ["A" "E" "I" "O" "U" "L" "N" "R" "S" "T"]
                      2  ["D" "G"]
                      3  ["B" "C" "M" "P"]
                      4  ["F" "H" "V" "W" "Y"]
                      5  ["K"]
                      8  ["J" "X"]
                      10 ["Q" "Z"]}))
  )