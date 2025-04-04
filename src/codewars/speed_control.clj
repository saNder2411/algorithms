(ns codewars.speed-control)

;; source: https://www.codewars.com/kata/56484848ba95170a8000004d

(defn gps [s x]
  (if (<= (count x) 1)
    0
    (let [speeds (reduce
                   (fn [acc i]
                     (let [delta-d (- (get x i) (get x (dec i)))]
                       (conj acc (/ (* 3600 delta-d) s))))
                   []
                   (range 1 (count x)))]
      (int (apply max speeds)))))
;;  1736ms

(defn gps-a [s x]
  (if (<= (count x) 1)
    0
    (let [res (reduce
                (fn [acc i]
                  (let [prev-d (get x (dec i))
                        cur-d (get x i)
                        delta-dist (- cur-d (if (nil? prev-d) 0 prev-d))
                        km (* 3600 delta-dist)
                        current-speed (/ km s)]
                    (max acc current-speed)))
                0
                (range 1 (count x)))]
      (int res))))
;; Time: 1721ms

(defn gps-b [s x]
  (if (<= (count x) 1)
    0
    (int
      (reduce
        (fn [acc i]
          (let [delta-dist (- (get x i) (get x (dec i)))
                current-speed (/ (* 3600 delta-dist) s)]
            (max acc current-speed)))
        0
        (range 1 (count x))))))
;; Time: 1686ms

(defn gps-c [s x]
  (if (<= (count x) 1)
    0
    (int
      (reduce
        #(max %1 (/ (* 3600 (- (get x %2) (get x (dec %2)))) s))
        0
        (range 1 (count x))))))

(defn gps-d [s x]
  (let [len (count x)]
    (if (<= len 1)
      0
      (int
        (loop [i 1
               max-speed 0]
          (if (< i len)
            (let [delta-dist (- (get x i) (get x (dec i)))

                  current-speed (/ (* 3600 delta-dist) s)]
              (recur (inc i) (max max-speed current-speed)))
            max-speed))))))

(defn gps-e [s x]
  (if (<= (count x) 1)
    0
    (let [res (loop [i 1
                     max-speed 0]
                (if (< i (count x))
                  (recur (inc i) (max max-speed (/ (* 3600 (- (get x i) (get x (dec i)))) s)))
                  max-speed))]
      (short res))))

(defn gps-f [s x]
  (if (<= (count x) 1)
    0
    (let [x-vec (if (vector? x) x (vec x))
          res (loop [i 1
                     max-speed 0]
                (if (< i (count x))
                  (recur (inc i) (max max-speed (/ (* 3600 (- (get x-vec i) (get x-vec (dec i)))) s)))
                  max-speed))]
      (int res))))

(defn gps-g [s x]
  (->> (partition 2 1 x)
       (map (fn [[p c]] (- c p)))
       (map #(* % 3600.0))
       (map #(/ % s))
       (reduce max 0)
       long))

(defn gps-h [s x]
  (if (<= (count x) 1)
    0
    (int
      (apply
        max
        (map
          #(/ (* % 3600) (float s))
          (map - (rest x) x))))))

(defn gps-s [s x]
  (if (< 1 (count x))
    (let [hourly-speed #(/ (* 3600 %) s)
          distances (map - (rest x) x)
          speeds (map hourly-speed distances)
          max-speed (apply max speeds)]
      (int max-speed))
    0))


(comment
  (time (gps 20 []))
  (time (gps-a 20 []))
  (time (gps-b 20 []))
  (time (gps-d 20 []))

  (time (gps 20 [1]))
  (time (gps-a 20 [1]))
  (time (gps-b 20 [1]))
  (time (gps-d 20 [1]))

  (time (gps 20 [0 0.23 0.46 0.69 0.92 1.15 1.38 1.61]))
  (time (gps-a 20 [0 0.23 0.46 0.69 0.92 1.15 1.38 1.61]))
  (time (gps-b 20 [0 0.23 0.46 0.69 0.92 1.15 1.38 1.61]))
  (time (gps-d 20 [0 0.23 0.46 0.69 0.92 1.15 1.38 1.61]))

  (time (gps 12 [0 0.11 0.22 0.33 0.44 0.65 1.08 1.26 1.68 1.89 2.1 2.31 2.52 3.25]))
  (time (gps-a 12 [0 0.11 0.22 0.33 0.44 0.65 1.08 1.26 1.68 1.89 2.1 2.31 2.52 3.25]))
  (time (gps-b 12 [0 0.11 0.22 0.33 0.44 0.65 1.08 1.26 1.68 1.89 2.1 2.31 2.52 3.25]))
  (time (gps-d 12 [0 0.11 0.22 0.33 0.44 0.65 1.08 1.26 1.68 1.89 2.1 2.31 2.52 3.25]))

  (time (gps 20 [0 0.18 0.36 0.54 0.72 1.05 1.26 1.47 1.92 2.16 2.4 2.64 2.88 3.12 3.36 3.6 3.84]))
  (time (gps-a 20 [0 0.18 0.36 0.54 0.72 1.05 1.26 1.47 1.92 2.16 2.4 2.64 2.88 3.12 3.36 3.6 3.84]))
  (time (gps-b 20 [0 0.18 0.36 0.54 0.72 1.05 1.26 1.47 1.92 2.16 2.4 2.64 2.88 3.12 3.36 3.6 3.84]))
  (time (gps-d 20 [0 0.18 0.36 0.54 0.72 1.05 1.26 1.47 1.92 2.16 2.4 2.64 2.88 3.12 3.36 3.6 3.84]))

  (time (gps-f 20 '(0.0 0.03 0.24 0.48)))

  (time (gps 20 (vec (range 0 100000001))))
  (time (gps-a 20 (vec (range 0 100000001))))
  (time (gps-b 20 (vec (range 0 100000001))))
  (time (gps-c 20 (vec (range 0 100000001))))
  (time (gps-d 20 (vec (range 0 100000001))))
  (time (gps-e 20 (vec (range 0 100000001))))

  (time (gps-f 20 (vec (range 0 100000001))))

  (time (gps-g 20 (vec (range 0 100000001))))
  (time (gps-h 20 (vec (range 0 100000001))))
  (time (gps-s 20 (vec (range 0 100000001))))
  )