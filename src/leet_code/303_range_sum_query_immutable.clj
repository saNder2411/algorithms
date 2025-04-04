(ns leet-code.303-range-sum-query-immutable)

;; source: https://leetcode.com/problems/range-sum-query-immutable/

(def sums (atom []))

(defn init-sums [nums]
  (loop [[num & remaining] nums
         current-sum 0
         sums! []]
    (if (nil? num)
      (reset! sums sums!)
      (let [sum (+ current-sum num)]
        (recur remaining sum (conj sums! sum))))))

(defn sum-range [left right]
  (if (= left 0)
    (get @sums right)
    (- (get @sums right) (get @sums (dec left)))))

(defn sum-range-a [nums left right]
  (let [right-index-nums (take (inc right) nums)]
    (if (= left 0)
      (apply + right-index-nums)
      (apply + (drop left right-index-nums)))))

;[-2 -2 1 -4 -2 -3]
(comment
  (time (init-sums [-2, 0, 3, -5, 2, -1]))

  (time (sum-range 0 2))
  (time (sum-range 2 5))
  (time (sum-range 0 5))

  (time (sum-range-a [-2, 0, 3, -5, 2, -1] 0 2))
  (time (sum-range-a [-2, 0, 3, -5, 2, -1] 2 5))
  (time (sum-range-a [-2, 0, 3, -5, 2, -1] 0 5))

  )