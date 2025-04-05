(ns exercism.armstrong-numbers
  (:require [clojure.math :as math]))

;; source: https://exercism.org/tracks/clojure/exercises/armstrong-numbers


(defn armstrong? [num]
  (let [nums (map #(-> % str read-string) (str num))
        exponent (count nums)
        res (apply + (map #(math/pow % exponent) nums))]
    (= (float num) (float res))))

;; --------------------------------------

(defn pow [y x]
  (apply * (repeat y x)))

(defn ->digits [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(rem % 10))))

(defn armstrong-1? [num]
  (let [digits (->digits num)]
    (->> digits
         (map (partial pow (count digits)))
         (apply +)
         (= num))))

(comment
(armstrong? 9474)
(armstrong-1? 9474)
  )