(ns leet-code.70-climbing-stairs)

;; source: https://leetcode.com/problems/climbing-stairs/

(defn climb-stairs [n]
  (if (= n 1)
    n
    (let [steps (range 3 (inc n))]
      (loop [n1 1
             n2 2
             i 0]
        (if (< i (count steps))
          (recur n2 (+ n1 n2) (inc i))
          n2)))))

(comment
  (climb-stairs 5)
  )