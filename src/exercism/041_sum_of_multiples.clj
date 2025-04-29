(ns exercism.041-sum-of-multiples)

; source: https://exercism.org/tracks/clojure/exercises/sum-of-multiples

(defn- multiples-of-n_ [n limit]
  (loop [i 1
         result []]
    (if (>= (* i n) limit)
      result
      (recur (inc i) (conj result (* i n))))))

(defn- multiples-of-n [n limit]
  (map #(* % n) (range 1 (inc (quot (dec limit) n)))))

(defn sum-of-multiples [factors limit]
  (->> factors
       (reduce #(into %1 (range %2 limit %2)) #{0})
       (apply +)))

(comment
  (multiples-of-n_ 5 20)
  (multiples-of-n 5 20)

  (sum-of-multiples '(3 5) 1)
  (sum-of-multiples '(3 5) 4)
  (sum-of-multiples '(3) 7)

  (take 10 (iterate (partial * 3) 1))
  )