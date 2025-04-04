(ns leet-code.268-missing-number)

;; source: https://leetcode.com/problems/missing-number/description/

(defn missing-num [nums]
  (let [correct-nums (-> nums count inc range)
        correct-sum (apply + correct-nums)
        missing-sum (apply + nums)]
    (- correct-sum missing-sum)))

(defn missing-num-a [nums]
  (let [n (count nums)
        sum (apply + nums)]
    (- (/ (* n (+ n 1)) 2) sum)))

(comment
  (missing-num [9 6 4 2 3 5 7 0 1])
  (missing-num [0 1 2 4])

  (missing-num-a [9 6 4 2 3 5 7 0 1])
  (missing-num-a [0 1 2 4])
  )
