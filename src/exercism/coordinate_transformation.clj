(ns exercism.coordinate-transformation)

;; source: https://exercism.org/tracks/clojure/exercises/coordinate-transformation

(defn translate2d [dx dy]
  (fn [x y]
    [(+ x dx) (+ y dy)]))

(defn scale2d [sx sy]
  (fn [x y]
    [(* x sx) (* y sy)]))

(defn compose-transform [f g]
  (fn [x y]
    (->> (f x y)
         (apply g))))

(defn memoize-transform [f]
  (let [cache (atom {:args [] :res nil})]
    (fn [x y]
      (let [{:keys [args res]} @cache
            [xc yc] args]
        (if (and (= x xc) (= y yc))
          res
          (:res (swap! cache assoc :args [x y] :res (f x y))))))))

