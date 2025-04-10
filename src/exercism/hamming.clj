(ns exercism.hamming)

;; source: https://exercism.org/tracks/clojure/exercises/hamming


(defn distance [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (apply + (map #(if (= %1 %2) 0 1) strand1 strand2))
    (throw (IllegalArgumentException. "strands must be of equal length"))))

(comment
  (distance "GGACGGATTCTG" "AGGACGGATTCA")
  )
