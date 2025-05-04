(ns exercism.052-sublist)

; source: https://exercism.org/tracks/clojure/exercises/sublist

(defn- sub-seq? [coll part]
  (if (<= (count coll) (count part))
    false
    (->> coll
         (partition (count part) 1)
         (some (partial = part)))))

(defn classify [a b]
  (cond (= a b) :equal
        (sub-seq? a b) :superlist
        (sub-seq? b a) :sublist
        :else :unequal))

(comment

  (classify [] [])
  (classify [] [1 2 3])
  (classify [1 2 3] [])
  (classify [1 2 3] [1 2 3])
  (classify [1 2 3] [2 3 4])
  (classify [1 2 5] [0 1 2 3 1 2 5 6])
  (classify [1 1 2] [0 1 1 1 2 1 2])
  (classify [0 1 2] [0 1 2 3 4 5])
  (classify [2 3 4] [0 1 2 3 4 5])
  (classify [3 4 5] [0 1 2 3 4 5])
  (classify [0 1 2 3 4 5] [0 1 2])
  (classify [0 1 2 3 4 5] [2 3])
  (classify [0 1 2 3 4 5] [3 4 5])
  (classify [1 3] [1 2 3])
  (classify [1 2 3] [1 3])
  (classify [1 2] [1 22])
  (classify [1 2 3] [3 2 1])
  (classify [1 0 1] [10 1])
  )