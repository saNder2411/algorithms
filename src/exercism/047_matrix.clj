(ns exercism.047-matrix
  (:require [clojure.string :as st]))

; source: https://exercism.org/tracks/clojure/exercises/matrix

(defn- str->matrix [s]
  (->> s
       (st/split-lines)
       (mapv (comp read-string #(format "[%s]" %)))))

(defn get-row [s i]
  (get (str->matrix s) (dec i)))

(defn get-column [s i]
  (mapv #(get % (dec i)) (str->matrix s)))



(comment
  (apply mapv vector (str->matrix "1 2 3\n4 5 6\n7 8 9\n8 7 6"))
  (get-row "1" 1)
  (get-row "1 2\n3 4" 2)
  (get-row "1 2\n10 20" 2)
  (get-row "1 2 3\n4 5 6\n7 8 9\n8 7 6" 4)

  (get-column "1" 1)
  (get-column "1 2 3\n4 5 6\n7 8 9" 3)
  (get-column "1 2 3 4\n5 6 7 8\n9 8 7 6" 4)
  (get-column "89 1903 3\n18 3 1\n9 4 800" 2)
  )