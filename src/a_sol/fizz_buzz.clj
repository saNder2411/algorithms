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
  (let [res (cond-> ""
                    (zero? (mod n 3)) (str "Fizz")
                    (zero? (mod n 5)) (str "Buzz"))]
    (if (empty? res) (str n) res)))

;;-----------------------------------

(defn fizz-buzz-seq-0 [start-n end-n]
  (doseq [n (range start-n (inc end-n))]
    (println (num->fizz-buzz n))))

;;-----------------------------------

(defn fizz-buzz-seq-1 [start end]
  (println
    (apply str
           (for [n (range start (inc end))]
             (let [res (cond-> ""
                               (zero? (mod n 3)) (str "Fizz")
                               (zero? (mod n 5)) (str "Buzz"))]
               (if (empty? res) (str n "\n") (str res "\n")))))))

;;-----------------------------------

(defmacro make-fb [start end]
  `(fn []
     (println
       ~(apply str
               (for [n (range start (inc end))]
                 (let [res (cond-> ""
                                   (zero? (mod n 3)) (str "Fizz")
                                   (zero? (mod n 5)) (str "Buzz"))]
                   (if (empty? res) (str n "\n") (str res "\n"))))))))

(def fizz-buzz-seq-2 (make-fb 1 100))

(comment

  (num->fizz-buzz 180)
  (time (fizz-buzz-seq-0 1 10000))
  ;; "Elapsed time: 111.422328 msecs"

  (time (fizz-buzz-seq-1 1 10000))
  ;; "Elapsed time: 2.226035 msecs"

  (time (fizz-buzz-seq-2))
  ;; "Elapsed time: 0.11046 msecs"

  (my-time 5 (fizz-buzz-seq-1 1 100))
  ;; "Elapsed time: 1629.845005 msecs"

  (my-time 5 (fizz-buzz-seq-2))
  ;; "Elapsed time: 82.574892 msecs"

  (macroexpand '(make-fb 1 30))
  )