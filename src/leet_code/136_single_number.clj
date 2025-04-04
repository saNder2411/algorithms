(ns leet-code.136-single-number)

;; source: https://leetcode.com/problems/single-number/

(defn single-number [nums]
  (loop [[num & remaining] nums
         acc #{}]
    (if (nil? num)
      (first acc)
      (if (contains? acc num)
        (recur remaining (disj acc num))
        (recur remaining (conj acc num))))))

(defn single-number-xor [nums]
  (loop [[num & remaining] nums
         mask 0]
    (if (nil? num)
      mask
      (recur remaining (bit-xor mask num)))))

(comment
  (single-number [2 2 1])
  (single-number [4 1 2 1 2])
  (single-number [1])
  (single-number [1 1])

  (single-number-xor [2 2 1])
  (single-number-xor [4 1 2 1 2])
  (single-number-xor [1])
  (single-number-xor [1 1])
  )