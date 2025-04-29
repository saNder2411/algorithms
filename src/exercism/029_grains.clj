(ns exercism.029-grains)

; source: https://exercism.org/tracks/clojure/exercises/grains

(defn- factor-2 [n] (bigint (* n 2)))

(defn- iterate-factor-2 [n]
  (take n (iterate factor-2 1)))

(defn square [n]
  (last (iterate-factor-2 n)))

(defn total []
  (apply + (iterate-factor-2 64)))

(comment
  (square 64) 9223372036854775808
  (total)

  )