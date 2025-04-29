(ns exercism.037-square-root)

; source: https://exercism.org/tracks/clojure/exercises/square-root

(defn square-root-linear [n]
  (loop [i 1]
    (if (<= (* i i) n)
      (recur (inc i))
      (dec i))))

(defn square-root-binary [n]
  (loop [l 0
         r (inc n)]
    (cond
      (= l (dec r)) l
      :else (let [m (quot (+ l r) 2)
                  [l1 r1] (if (<= (* m m) n)
                            [m r]
                            [l m])]
              (recur l1 r1)))))

(defn square-root-euclidean-division [n]
  (->> n
       (iterate #(float (/ (+ % (/ n %)) 2)))
       (partition 2 1)
       (take-while (fn [[a b]] (not= a b)))
       (last)
       (first)
       int))

(defn square-root-euclidean-division- [n]
  (if (<= n 1)
    n
    (int (loop [a (/ n 2)
                b (float (/ (+ a (/ n a)) 2))]
           (cond
             (< b a) (recur b (float (/ (+ b (/ n b)) 2)))
             :else a)))))

(comment
  (square-root-euclidean-division- 1)
  (square-root-binary 4)
  (square-root-binary 25)
  (square-root-binary 81)

  (time (square-root-binary 1000002000001))
  (time (square-root-linear 1000002000001))
  (time (square-root-euclidean-division 1000002000001))

  (time (square-root-euclidean-division- 1000002000001))
  )


