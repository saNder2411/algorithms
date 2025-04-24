(ns exercism.difference-of-squares)

; source: https://exercism.org/tracks/clojure/exercises/difference-of-squares

(defn- pow [n] (* n n))

(defn square-of-sum [n]
  (->> (inc n)
       (range 1)
       (apply +)
       pow))

(defn sum-of-squares [n]
  (->> (inc n)
       (range 1)
       (map pow)
       (apply +)))

(defn difference [n]
  (- (square-of-sum n) (sum-of-squares n)))

(comment
  (square-of-sum 1)
  (square-of-sum 5)
  (square-of-sum 100)

  (sum-of-squares 1)
  (sum-of-squares 5)
  (sum-of-squares 100)

  (difference 1)
  (difference 5)
  (difference 100)

  )