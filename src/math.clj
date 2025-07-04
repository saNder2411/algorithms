(ns math)

(defn mean [nums]
  (float (/ (apply + nums) (count nums))))

(defn median [nums]
  (let [nums! (sort nums)
        lng (count nums!)
        m (quot lng 2)]
    (float
      (if (odd? lng)
        (last (take (inc m) nums!))
        (let [lft (take m nums!)
              rgt (drop m nums!)]
          (/ (+ (last lft) (first rgt)) 2))))))

(defn quartiles [nums]
  (let [nums! (sort nums)
        lng (count nums!)
        m (quot lng 2)
        lft (take m nums!)
        rgt-start (if (odd? lng) (inc m) m)
        rgt (drop rgt-start nums!)]
    [(median lft) (median rgt)]))

(defn iq-range [nums]
  (let [[q1 q3] (quartiles nums)]
    (- q3 q1)))

(defn create-box-plot [nums]
  (let [nums! (sort nums)
        [q1 q3] (quartiles nums!)]
    [(first nums!) q1 (median nums!) q3 (last nums!)]))

(defn mad [nums]
  (let [avr (mean nums)]
    (mean (map #(abs (- % avr)) nums))))

(defn compound-probability-table [h-row h-col cond-fn]
  (let [den (* (count h-row) (count h-col))
        table (mapv #(mapv vector h-row (repeat %)) h-col)
        data-set (apply concat table)
        n (reduce (fn [acc el]
                    (if (apply cond-fn el)
                      (inc acc)
                      acc)) 0 data-set)]
    (/ n den)))

(comment
  (mean [1.29 1.92 3.19 3.79 3.99 4.79 5.19 5.29 5.49 6.75 7.19 39.99])
  (mean [1 4 3 2])
  (median [1.29 1.92 3.19 3.79 3.99 4.79 5.19 5.29 5.49 6.75 7.19 39.99])
  (median [1.29 1.92 3.19 3.79 3.99 4.79 5.19 5.29 5.49 6.75 7.19])
  (iq-range [0 0 0 1 1 3 3 4 7 7])
  (create-box-plot [1 2 2 2 3 3 4 5 5 6 7 8 8 10])

  (mad [8 12 4 8])
  (compound-probability-table [1 2 3 4 5 6] [1 2 3 4 5 6] #(and (odd? %1) (odd? %2)))

  (compound-probability-table ["t" "r" "w"] ["t" "r" "w"] #(or (= "t" %1) (= "t" %2)))

  (compound-probability-table ["sht" "pns" "sks" "ht"] ["p" "b" "o"] #(and (= "ht" %1) (= "o" %2)))

  )
