(ns a-sol.fizz-buzz
  (:require [clojure.java.io :as io])
  (:import [java.io OutputStream]))

(def dev-null (io/writer (OutputStream/nullOutputStream)))

(defmacro my-time [n expr]
  `(with-out-str
     (time
       (dotimes [_# ~(Math/pow 10 n)]
         (binding [*out* dev-null]
           ~expr)))))

;;-----------------------------------

(defn num->fizz-buzz [n]
  (cond
    (and (zero? (mod n 3)) (zero? (mod n 5))) "FizzBuzz"
    (zero? (mod n 3)) "Fizz"
    (zero? (mod n 5)) "Buzz"
    :else n))

(defn fizz-buzz-v-0 [start-n end-n]
  (doseq [n (range start-n (inc end-n))]
    (println (num->fizz-buzz n))))

;;-----------------------------------

(defn fizz-buzz-v-1 [start end]
  (doseq [n (range start (inc end))]
    (println
      (cond
        (zero? (mod n 15)) "FizzBuzz"
        (zero? (mod n 3)) "Fizz"
        (zero? (mod n 5)) "Buzz"
        :else n))))

;;-----------------------------------

(defn fizz-buzz-v-2 [start end]
  (println
    (apply str
           (for [n (range start (inc end))]
             (cond
               (zero? (mod n 15)) "FizzBuzz\n"
               (zero? (mod n 3)) "Fizz\n"
               (zero? (mod n 5)) "Buzz\n"
               :else (str n "\n"))))))

;;-----------------------------------

(defmacro make-fb [start end]
  `(fn []
     (println
       ~(apply str
               (for [n (range start (inc end))]
                 (cond
                   (zero? (mod n 15)) "FizzBuzz\n"
                   (zero? (mod n 3)) "Fizz\n"
                   (zero? (mod n 5)) "Buzz\n"
                   :else (str n "\n")))))))

(def fizz-buzz-v-3 (make-fb 1 100))

(comment
  (time (fizz-buzz-v-0 1 10000))
  ;; "Elapsed time: 121.393147 msecs"

  (time (fizz-buzz-v-1 1 10000))
  ;; "Elapsed time: 118.889255 msecs"

  (time (fizz-buzz-v-2 1 10000))
  ;; "Elapsed time: 4.023513 msecs"

  (time (fizz-buzz-v-2-c 1 10000))

  (time (fizz-buzz-v-3))
  ;; "Elapsed time: 1.205072 msecs"

  (my-time 5 (fizz-buzz-v-1 1 100))
  ;; "Elapsed time: 5402.197219 msecs"

  (my-time 5 (fizz-buzz-v-2 1 100))
  ;; "Elapsed time: 863.081299 msecs"

  (my-time 5 (fizz-buzz-v-3))
  ;; "Elapsed time: 86.575677 msecs"

  (macroexpand '(make-fb 1 30))
  )