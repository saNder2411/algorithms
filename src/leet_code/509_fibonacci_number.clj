(ns leet-code.509-fibonacci-number)

;; source: https://leetcode.com/problems/fibonacci-number/

(defn fib-cache [n]
  (let [cache (atom {})]
    (letfn [(inner [n]
              (cond
                (= n 0) 0
                (= n 1) 1
                (get @cache n) (get @cache n)
                :else (-> (swap! cache assoc n (+ (inner (- n 1)) (inner (- n 2))))
                          (get n))))]

      (inner n))))

(defn fib-dp-linear [n]
  (if (= n 0)
    0
    (let [dp (atom (into [0 1] (repeat (dec n) 0)))]
      (doseq [i (range 2 (inc n))]
        (swap! dp assoc i (+ (get @dp (- i 1)) (get @dp (- i 2)))))
      (get @dp n))))

(defn fib-dp-linear-1 [n]
  (if (= n 0)
    0
    (loop [i 2
           dp [0 1]]
      (if (<= i (inc n))
        (recur (inc i) (assoc dp i (+ (get dp (- i 1)) (get dp (- i 2)))))
        (get dp n)))))

(defn fib [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (loop [i 1
                 n1 0
                 n2 1]
            (if (= i n)
              n2
              (recur (inc i) n2 (+ n1 n2))))))

(defn fib-a [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (loop [i 2
                 n1 0
                 n2 1]
            (if (= i (inc n))
              n2
              (recur (inc i) n2 (+ n1 n2))))))

(defn fib-fn [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (second (reduce (fn [[a b] _]
                            [b (+ a b)])
                          [0 1]
                          (range 2 (inc n))))))


(comment
  (time (fib-cache 3))
  (time (fib-dp-linear 3))
  (time (fib-dp-linear-1 3))
  (time (fib 3))
  (time (fib-a 3))
  (time (fib-fn 3))


  (time (fib-cache 4))
  (time (fib-dp-linear 4))
  (time (fib-dp-linear-1 4))
  (time (fib 4))
  (time (fib-a 4))
  (time (fib-fn 4))


  (time (fib-cache 5))
  (time (fib-dp-linear 5))
  (time (fib-dp-linear-1 5))
  (time (fib 5))
  (time (fib-a 5))
  (time (fib-fn 5))


  (time (fib-cache 6))
  (time (fib-dp-linear 6))
  (time (fib-dp-linear-1 6))
  (time (fib 6))
  (time (fib-a 6))
  (time (fib-fn 6))


  (time (fib-cache 10))
  (time (fib-dp-linear 10))
  (time (fib-dp-linear-1 10))
  (time (fib 10))
  (time (fib-a 10))


  (time (fib-cache 20))
  (time (fib-dp-linear 20))
  (time (fib-dp-linear-1 20))
  (time (fib 20))
  (time (fib-a 20))


  (time (fib-cache 30))
  (time (fib-dp-linear 30))
  (time (fib-dp-linear-1 30))
  (time (fib 30))
  (time (fib-a 30))

  (time (fib-cache 40))
  (time (fib-dp-linear 40))
  (time (fib-dp-linear-1 40))
  (time (fib 70))
  (time (fib-a 70))
  (time (fib-fn 70))
  )