(ns exercism.059-prime-factors)

; source: https://exercism.org/tracks/clojure/exercises/prime-factors

(defn of [num]
  (loop [div 2
         r num
         res []]
    (cond (<= r 1) res
          (zero? (mod r div)) (recur div (/ r div) (conj res div))
          :else (recur (inc div) r res))))

(comment
  (of 1)
  (of 2)
  (of 3)
  (of 9)
  (of 4)
  (of 8)
  (of 27)
  (of 625)
  (of 6)
  (of 12)
  (of 901255)
  (of 93819012551)
  )