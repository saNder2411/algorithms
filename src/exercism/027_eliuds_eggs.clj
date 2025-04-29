(ns exercism.027-eliuds-eggs)

;; source: https://exercism.org/tracks/clojure/exercises/eliuds-eggs

(defn num-10->binary [num]
  (loop [div num
         res '()]
    (if (= div 0)
      (if (empty? res) '(0) res)
      (recur (quot div 2) (conj res (mod div 2))))))

(defn egg-count [number]
  (apply + (num-10->binary number)))

(defn egg-count-1 [number]
  (->> number
       (iterate #(bit-shift-right % 1))
       (take-while pos?)
       (filter odd?)
       count))

(defn egg-count-2 [n]
  (->> n
       (iterate #(quot % 2))
       (take-while pos?)
       (map #(rem % 2))
       (apply +)))


(comment


  (time (egg-count 189189189189))
  (time (egg-count-1 189189189189))
  (time (egg-count-2 189189189189))

  )