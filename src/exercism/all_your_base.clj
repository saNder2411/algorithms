(ns exercism.all-your-base
  (:require [clojure.math :as math]))

;; source: https://exercism.org/tracks/clojure/exercises/all-your-base

(defn base-n->base-10 [base-n nums]
  (let [exponents (range (dec (count nums)) -1 -1)]
    (int (apply + (map #(* %1 (math/pow base-n %2)) nums exponents)))))

(defn base-10->list-div [num]
  (map read-string (clojure.string/split (str num) #"")))

(defn base-10->base-n [base nums]
  (let [b10 (base-n->base-10 10 nums)]
    (loop [div b10
           res '()]
      (if (= div 0)
        (if (empty? res) '(0) res)
        (recur (quot div base) (conj res (mod div base)))))))

(defn convert [base-in nums base-out]
  (cond
    (or (< base-in 2) (< base-out 2)) nil
    (empty? nums) nums
    (some #(< % 0) nums) nil
    (some #(>= % base-in) nums) nil
    (= base-out 10) (base-10->list-div (base-n->base-10 base-in nums))
    :else (let [nums-10 (base-10->list-div (base-n->base-10 base-in nums))]
            (base-10->base-n base-out nums-10))))


;; mentor's solution
(defn- valid-digits? [digits base]
  (every? (fn [digit] (<= 0 digit (dec base))) digits))

(defn- evaluate [digits base]
  (reduce (fn [sum digit] (+ (* sum base) digit)) 0 digits))

(defn- split [n base]
  (loop [m n
         result '()]
    (if (< m base)
      (cons m result)
      (recur (quot m base) (cons (mod m base) result)))))

(defn convert-a [in digits out]
  (cond (empty? digits) nil
        (< in 2) nil
        (< out 2) nil
        (valid-digits? digits in) (split (evaluate digits in) out)
        :else nil))

(comment
  (convert 2 '(1) 10)
  (convert 2 '(1 0 1) 10)
  (convert 10 '(5) 2)
  (convert 2 '(1 0 1 0 1 0) 10)
  (convert 10 '(4 2) 2)
  (convert 3 '(1 1 2 0) 16)
  (convert 16 '(2 10) 3)
  (convert 97 '(3 46 60) 73)

  (convert 2 () 10)
  (convert 10 '(0) 2)
  (convert 10 '(0 0 0) 2)

  (convert 7 '(0 6 0) 10)
  (convert 2 '(1 -1 1 0 1 0) 10)
  (convert 2 '(1 2 1 0 1 0) 10)
  (convert 1 () 10)
  (convert 2 '(1 0 1 0 1 0) 1)
  (convert 0 () 10)
  (convert 10 '(7) 0)
  (convert -2 '(1) 10)
  (convert 2 '(1) -7)
  (convert -2 '(1) -7)

  (convert-a 2 '(1) 10)
  (convert-a 2 '(1 0 1) 10)
  (convert-a 10 '(5) 2)
  (convert-a 2 '(1 0 1 0 1 0) 10)
  (convert-a 10 '(4 2) 2)
  (convert-a 3 '(1 1 2 0) 16)
  (convert-a 16 '(2 10) 3)
  (convert-a 97 '(3 46 60) 73)
  )
