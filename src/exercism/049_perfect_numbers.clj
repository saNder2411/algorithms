(ns exercism.049-perfect-numbers)

;; source: https://exercism.org/tracks/clojure/exercises/perfect-numbers

(defn factors [n]
  (reduce
    (fn [acc x]
      (if (zero? (mod n x))
        (conj acc x (/ n x))
        acc))
    #{}
    (range 1 (inc (Math/sqrt n)))))

(defn classify [num]
  (let [f-sum (apply + (disj (factors num) num))]
    (cond (< f-sum num) :deficient
          (> f-sum num) :abundant
          :else :perfect)))


(comment
  (factors 28)

  (classify 6)

  (classify 28)

  (classify 33550336)

  (classify 12)

  (classify 30)

  (classify 33550335)

  (classify 2)

  (classify 4)

  (classify 32)

  (classify 33550337)

  (classify 1)
  )