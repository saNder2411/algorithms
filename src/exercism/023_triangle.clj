(ns exercism.023-triangle)

;; source: https://exercism.org/tracks/clojure/exercises/triangle

(defn- triangle? [a b c]
  (and (< 0 a)
       (< 0 b)
       (< 0 c)
       (>= (+ a b) c)
       (>= (+ c b) a)
       (>= (+ c a) b)))

(defn equilateral? [a b c]
  (and (triangle? a b c)
       (= a b c)))

(defn isosceles? [a b c]
  (and (triangle? a b c)
       (or (= a b) (= a c) (= b c))))

(defn scalene? [a b c]
  (and (triangle? a b c)
       (not (isosceles? a b c))))

(comment
  (equilateral? 2 2 2)
  (equilateral? 2 3 2)
  (equilateral? 5 4 6)
  (equilateral? 0 0 0)
  (equilateral? 0.5 0.5 0.5)
  (isosceles? 3 4 4)
  (isosceles? 4 4 3)
  (isosceles? 4 3 4)
  (isosceles? 4 4 4)
  (isosceles? 2 3 4)
  (isosceles? 1 1 3)
  (isosceles? 1 3 1)
  (isosceles? 3 1 1)
  (isosceles? 0.5 0.4 0.5)
  (scalene? 5 4 6)
  (scalene? 4 4 4)
  (scalene? 4 4 3)
  (scalene? 3 4 3)
  (scalene? 4 3 3)
  (scalene? 7 3 2)
  (scalene? 0.5 0.4 0.6)
  )