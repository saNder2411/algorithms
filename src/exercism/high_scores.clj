(ns exercism.high-scores)

;; source: https://exercism.org/tracks/clojure/exercises/high-scores

(defn scores [scores] scores)

(defn latest [scores] (last scores))

(defn personal-best [scores] (apply max scores))

(defn personal-top-three [scores]
  (->> scores
       (sort >)
       (take 3)))

(comment
  (scores '(30 50 20 70))
  (latest '(100 0 90 30))
  (personal-best '(40 100 70))
  (personal-top-three '(10 30 90 30 100 20 10 0 30 40 40 70 70))

  )