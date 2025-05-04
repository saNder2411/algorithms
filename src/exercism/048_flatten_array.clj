(ns exercism.048-flatten-array)

;; source: https://exercism.org/tracks/clojure/exercises/flatten-array

(defn flatten [coll]
  (loop [[fst & rst :as data] coll
         result []]
    (cond (empty? data) result
          (coll? fst) (recur (into fst rst) result)
          (nil? fst) (recur rst result)
          :else (recur rst (conj result fst)))))

(comment

  (flatten [])
  (flatten [0 1 2])
  (flatten [[[]]])
  (flatten [1 [2 3 4 5 6 7] 8])
  (flatten [0 2 [[2 3] 8 100 4 [[[50]]]] -2])  (flatten [1 [2 [[3]] [4 [[5]]] 6 7] 8])
  (flatten [1 2 nil])
  (flatten [nil nil 3])
  (flatten [1 nil nil 4])
  (flatten [0 2 [[2 3] 8 [[100]] nil [[nil]]] -2])
  (flatten [nil [[[nil]]] nil nil [[nil nil] nil] nil])
  )
