(ns exercism.024-raindrops)

;; source: https://exercism.org/tracks/clojure/exercises/raindrops

(defn convert [num]
  (let [res (cond-> ""
                    (zero? (mod num 3)) (str "Pling")
                    (zero? (mod num 5)) (str "Plang")
                    (zero? (mod num 7)) (str "Plong"))]
    (if (empty? res) (str num) res)))

(comment
  (convert 105)
  )