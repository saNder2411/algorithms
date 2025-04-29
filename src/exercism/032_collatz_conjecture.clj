(ns exercism.032-collatz-conjecture)

;; source: https://exercism.org/tracks/clojure/exercises/collatz-conjecture

(defn- collatz-step [n]
  (if (odd? n)
    (inc (* 3 n))
    (/ n 2)))

(defn collatz [num]
  (loop [i 0
         next-n num]
    (if (= next-n 1)
      i
      (recur (inc i) (collatz-step next-n)))))

(defn collatz-1 [n]
  (->> n
       (iterate collatz-step)
       (take-while (partial not= 1))
       count))

(comment
  (time (collatz 121212121121212121))
  (time (collatz-1 121212121121212121))

  )