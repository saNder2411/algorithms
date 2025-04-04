(ns leet-code.53-maximum-subarray)

;; source: https://leetcode.com/problems/maximum-subarray/

(defn max-sub-array [nums]
  (loop [i 1
         current-sum (get nums 0)
         max-sum (get nums 0)]
    (if (< i (count nums))
      (let [num (get nums i)
            current-sum! (max (+ current-sum num) num)
            max-sum! (max current-sum! max-sum)]
        (recur (inc i) current-sum! max-sum!))
      max-sum)))

(comment
  (max-sub-array [-2 1 -3 4 -1 2 1 -5 4])
  (max-sub-array [1])
  (max-sub-array [5 4 -1 7 8])
  )