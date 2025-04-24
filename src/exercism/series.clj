(ns exercism.series)

; source: https://exercism.org/tracks/clojure/exercises/series

(defn slices [s n]
  (cond (empty? s) (throw (IllegalArgumentException. "series cannot be empty"))
        (> n (count s)) (throw (IllegalArgumentException. "slice length cannot be greater than series length"))
        (zero? n) (throw (IllegalArgumentException. "slice length cannot be zero"))
        (neg? n) (throw (IllegalArgumentException. "slice length cannot be negative"))
        :else (->> s
                   (partition n 1)
                   (mapv #(apply str %)))))

(comment

  (slices "1" 1)
  (slices "12" 1)
  (slices "35" 2)
  (slices "9142" 2)
  (slices "777777" 3)
  (slices "918493904243" 5)
  (slices "12345" 6)

  )