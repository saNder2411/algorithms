(ns exercism.darts)

;; source: https://exercism.org/tracks/clojure/exercises/darts

(defn- hypo [x y]
  (Math/sqrt (+ (* x x) (* y y))))

(defn score [x y]
  (condp >= (hypo x y)
    1 10
    5 5
    10 1
    0))


(comment
  (score -9 9)
  (score 0 10)
  (score -5 0)
  (score 0 -1)
  (score 0 0)
  (score -0.1 -0.1)
  (score 0.7 0.7)
  (score 0.8 -0.8)
  (score -3.5 3.5)
  (score -3.6 -3.6)
  (score -7.0 7.0)
  (score 7.1 -7.1)
  (score 0.5 -4)

  )