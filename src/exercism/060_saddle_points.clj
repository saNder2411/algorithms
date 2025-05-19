(ns exercism.060-saddle-points)

; source: https://exercism.org/tracks/clojure/exercises/saddle-points

;Step 1:
;First of all, we need to iterate through each row and check during each iteration whether the current point is a peak.
;Why do we need to check every value in the row instead of stopping at the first peak?
;Because a row might contain multiple peak points, and we need to examine each one.
;
;Step 2:
;Next, we need to check whether this point is the smallest (or one of the smallest) in its column.
;
;Step 3:
;If both conditions are met, we should return a vector with the two indices of the point:
;
;The first index is its position in the column — that is, the row index in the matrix, which represents its y-coordinate.
;
;The second index is its position in the row — the column index in the matrix, which represents its x-coordinate.

(defn- turn-over-matrix [matrix]
  (vec (map-indexed (fn [i _]
                      (mapv #(get % i) matrix))
                    (first matrix))))

(defn saddle-points [matrix]
  (let [col-matrix (turn-over-matrix matrix)]
    (:res (reduce (fn [{:keys [row-i res]} row]
                    (let [y-x (keep-indexed
                                (fn [i v]
                                  (let [col (get col-matrix i)]
                                    (when (and (= v (apply max row)) (= v (apply min col)))
                                      [(inc row-i) (inc i)])))
                                row)]
                      {:row-i (inc row-i)
                       :res   (into res y-x)}))
                  {:row-i 0 :res #{}}
                  matrix))))

(comment
  (saddle-points [[9 8 7]
                  [5 3 2]
                  [6 6 7]])

  (saddle-points [])

  (saddle-points [[1 2 3]
                  [3 1 2]
                  [2 3 1]])

  (saddle-points [[4 5 4]
                  [3 5 5]
                  [1 5 4]])

  (saddle-points [[4 5 4]
                  [3 5 5]
                  [1 5 4]])

  (saddle-points [[8 7 9]
                  [6 7 6]
                  [3 2 5]])

  (saddle-points [[3 1 3]
                  [3 2 4]])

  (saddle-points [[2]
                  [1]
                  [4]
                  [1]])

  (saddle-points [[2 5 3 5]])

  )