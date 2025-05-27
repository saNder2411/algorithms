(ns exercism.061-binary-search)

; source: https://exercism.org/tracks/clojure/exercises/binary-search


(defn search-for [num coll]
  (loop [l-i 0
         h-i (dec (count coll))]
    (if (< h-i l-i)
      -1
      (let [m-i (quot (+ l-i h-i) 2)
            el (get coll m-i)]
        (cond (= el num) m-i
              (> el num) (recur l-i (dec m-i))
              (< el num) (recur (inc m-i) h-i))))))

(comment

  (search-for 0 [0 1 2 3 4 5 6 7 8])
  (search-for 1 [0 1 2 3 4 5 6 7 8])
  (search-for 2 [0 1 2 3 4 5 6 7 8])
  (search-for 3 [0 1 2 3 4 5 6 7 8])
  (search-for 4 [0 1 2 3 4 5 6 7 8])
  (search-for 5 [0 1 2 3 4 5 6 7 8])
  (search-for 6 [0 1 2 3 4 5 6 7 8])
  (search-for 7 [0 1 2 3 4 5 6 7 8])
  (search-for 8 [0 1 2 3 4 5 6 7 8])
  (search-for 9 [0 1 2 3 4 5 6 7 8])
  (search-for -1 [0 1 2 3 4 5 6 7 8])

  (search-for 6 [6])
  (search-for 6 [1 3 4 6 8 9 11])
  (search-for 1 [1 3 4 6 8 9 11])
  (search-for 11 [1 3 4 6 8 9 11])
  (search-for 144 [1 3 5 8 13 21 34 55 89 144 233 377 634])
  (search-for 21 [1 3 5 8 13 21 34 55 89 144 233 377])
  (search-for 7 [1 3 4 6 8 9 11])
  (search-for 0 [1 3 4 6 8 9 11])
  (search-for 13 [1 3 4 6 8 9 11])
  (search-for 1 [])
  (search-for 0 [1 2])
  )
