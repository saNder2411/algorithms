(ns leet-code.121-best-time-to-buy-and-sell-stock)

;; source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

(defn max-profit-v [prices]
  (loop [i 0
         max-prof 0
         current-min (get prices i)]
    (if (< i (count prices))
      (let [price (get prices i)
            max-prof! (max max-prof (- price current-min))
            current-min! (min current-min price)]
        (recur (inc i) max-prof! current-min!))
      max-prof)))



(comment
  (max-profit-v [7 1 5 3 6 4])
  (max-profit-v [7 6 4 3 1])
  (max-profit-v [7 2 9 1 5])
  (max-profit-v [7 2 5 9 1 4 5 7])
  )