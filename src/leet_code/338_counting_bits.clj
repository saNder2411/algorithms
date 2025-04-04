(ns leet-code.338-counting-bits)

;; source: https://leetcode.com/problems/counting-bits/

(defn count-bits [n]
  (loop [i 1
         memo (vec (repeat (inc n) 0))]
    (if (<= i n)
      (let [v (+ (get memo (bit-shift-right i 1)) (mod i 2))
            memo! (assoc memo i v)]
        (recur (inc i) memo!))
      memo)))

(defn count-bits-a [n]
  (let [memo (vec (repeat (inc n) 0))]
    (reduce
      (fn [acc i]
        (let [v (+ (get acc (bit-shift-right i 1)) (mod i 2))]
          (assoc acc i v)))
      memo
      (range 1 (inc n)))))

(defn count-bits-fast [n]
  (let [memo (vec (repeat (inc n) 0))]
    (reduce
      (fn [acc i]
        (assoc acc i (+ (get acc (bit-shift-right i 1)) (mod i 2))))
      memo
      (range 1 (inc n)))))


(comment
  (time (count-bits 2))
  (time (count-bits-a 2))
  (time (count-bits-fast 2))

  (time (count-bits 5))
  (time (count-bits-a 5))
  (time (count-bits-fast 5))

  (time (count-bits 10000))
  (time (count-bits-a 10000))
  (time (count-bits-fast 10000))

  (time (count-bits 1000000))
  (time (count-bits-a 1000000))
  (time (count-bits-fast 1000000))
  )