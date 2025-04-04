(ns leet-code.448-find-all-numbers-disappeared-in-an-array)

;; source: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

(defn cyclic-sort [nums]
  (loop [i 0
         sort-nums nums]
    (if (< i (count nums))
      (let [val (get sort-nums i)
            pos (dec val)
            val-from-pos (get sort-nums pos)
            [next-i sort-nums!] (if (= val val-from-pos)
                                  [(inc i) sort-nums]
                                  [i (-> sort-nums
                                         (assoc i val-from-pos)
                                         (assoc pos val))])]
        (recur next-i sort-nums!))
      sort-nums)))

(defn find-disappeared-numbers [nums]
  (let [sort-nums (cyclic-sort nums)
        res (for [i (range (count nums))
                  :let [item (inc i)]
                  :when (not= (get sort-nums i) item)]
              item)]
    (into [] res)))

(comment
  (find-disappeared-numbers [4 3 2 7 8 2 3 1])

  (find-disappeared-numbers [1 1])
  )