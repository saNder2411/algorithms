(ns exercism.025-strain
  (:require [clojure.string :as s]))

; source: https://exercism.org/tracks/clojure/exercises/strain

(defn retain [pred coll]
  (loop [result []
         [fst & rest] coll]
    (cond (nil? fst) result
          (pred fst) (recur (conj result fst) rest)
          :else (recur result rest))))

(defn discard [pred coll]
  (retain (complement pred) coll))

(comment
  (retain (fn [_] true) [])
  (retain (fn [_] true) [1 3 5])
  (retain (fn [_] false) [1 3 5])
  (retain odd? [1 2 3])
  (retain even? [1 2 3])
  (retain (fn [x] (s/starts-with? x "z")) ["apple" "zebra" "banana" "zombies" "cherimoya" "zealot"])
  (retain (fn [x] (boolean (some #{5} x))) [[1 2 3] [5 5 5] [5 1 2] [2 1 2] [1 5 2] [2 2 1] [1 2 5]])

  (discard (fn [_] true) [1 3 5])
  (discard (fn [_] false) [1 3 5])
  (discard odd? [1 2 3])
  (discard even? [1 2 3])
  (discard (fn [x] (s/starts-with? x "z")) ["apple" "zebra" "banana" "zombies" "cherimoya" "zealot"])
  (discard (fn [x] (boolean (some #{5} x))) [[1 2 3] [5 5 5] [5 1 2] [2 1 2] [1 5 2] [2 2 1] [1 2 5]])
  )
