(ns exercism.020-resistor-color-duo)

;; source: https://exercism.org/tracks/clojure/exercises/resistor-color-duo

(def colors->num
  {"black" 0
   "brown" 1
   "red" 2
   "orange" 3
   "yellow" 4
   "green" 5
   "blue" 6
   "violet" 7
   "grey" 8
   "white" 9})

(defn resistor-value- [colors]
  (let [[tens ones] (->> colors
                         (take 2)
                         (map colors->num))]
    (if (or (nil? tens) (nil? ones))
      0
      (+ (* tens 10) ones))))

(defn resistor-value [colors]
  (->> colors
       (take 2)
       (map colors->num)
       (reduce (fn [acc n] (+ (* acc 10) n)) 0)))

(comment
  (resistor-value [])

  (resistor-value ["brown" "black"])
  (resistor-value ["blue" "grey"])
  (resistor-value ["yellow" "violet"])
  (resistor-value ["white" "red"])
  (resistor-value ["orange" "orange"])
  (resistor-value ["green" "brown" "orange"])
  (resistor-value ["black" "brown"])

  )