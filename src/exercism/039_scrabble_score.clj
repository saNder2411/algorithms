(ns exercism.039-scrabble-score
  (:require [clojure.string :as s]))

; source: https://exercism.org/tracks/clojure/exercises/scrabble-score

(def score-map {\A 1 \E 1 \I 1 \O 1 \U 1 \L 1 \N 1 \R 1 \S 1 \T 1
                \D 2 \G 2
                \B 3 \C 3 \M 3 \P 3
                \F 4 \H 4 \V 4 \W 4 \Y 4
                \K 5
                \J 8 \X 8
                \Q 10 \Z 10})

(defn score-word [word]
  (reduce (fn [sum c]
            (+ sum (get score-map c))) 0 (s/upper-case word)))

(comment
  (score-word "a")
  (score-word "A")
  (score-word "f")
  (score-word "at")
  (score-word "zoo")
  (score-word "street")
  (score-word "quirky")
  (score-word "OxyphenButazone")
  (score-word "pinata")
  (score-word "")
  (score-word "abcdefghijklmnopqrstuvwxyz")
  )