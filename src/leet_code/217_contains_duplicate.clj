(ns leet-code.217-contains-duplicate)

;; source: https://leetcode.com/problems/contains-duplicate/description/

(defn contains-duplicate-a [nums]
  (> (count nums) (count (set nums))))

(defn contains-duplicate-b [nums]
  (loop [seen #{}
         [n & remaining] nums]
    (cond
      (contains? seen n) true
      (empty? remaining) false
      :else (recur (conj seen n) remaining))))


(comment
  (time
    (contains-duplicate-a [1 2 3 3 4 5 5]))

  (time
    (contains-duplicate-b [1 2 3 3 4 5 5]))
  )