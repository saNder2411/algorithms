(ns exercism.074-nth-prime)

;; source: https://exercism.org/tracks/clojure/exercises/nth-prime

(defn prime? [n]
  (cond (<= 0 n 1) false
        (<= 2 n 3) true
        :else (let [devs (vec (range 3 (inc (Math/sqrt n))))
                    last-i (dec (count devs))]
                (loop [i 0]
                  (let [dev (get devs i)
                        res (mod n dev)]
                    (if (zero? res)
                      false
                      (if (= i last-i)
                        true
                        (recur (inc i)))))))))

(defn next-prime [p]
  (if (= p 2)
    3
    (loop [next-p (+ p 2)]
      (if (prime? next-p)
        next-p
        (recur (+ next-p 2))))))

(defn nth-prime [n]
  (nth (iterate next-prime 2) (dec n)))



(comment

  (time (nth-prime 100001))

  (time (nth-prime-1 100001))



  )