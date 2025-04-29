(ns exercism.042-pascals-triangle)

; source: https://exercism.org/tracks/clojure/exercises/pascals-triangle



(defn row [prev-row]
  (into [1] (map #(apply + %) (partition 2 1 nil prev-row))))

(def triangle (iterate row [1]))

(comment
  (row [1 3 3 1])

  (take 0 triangle)
  (take 1 triangle)
  (take 2 triangle)
  (take 3 triangle)
  (take 4 triangle)
  (take 5 triangle)
  (take 6 triangle)
  (take 10 triangle)
  )