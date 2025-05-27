(ns exercism.065-binary-search-tree)

; source: https://exercism.org/tracks/clojure/exercises/binary-search-tree

(defrecord Node [value left right])

(defn singleton [v] (map->Node {:value v :left nil :right nil}))

(def value :value)
(def left :left)
(def right :right)

(defn path-and-last-node [v node path]
  (if (nil? node)
    [path (singleton v)]
    (let [cur-v (value node)
          dir (if (<= v cur-v) :left :right)
          next-node (dir node)]
      (recur v next-node (conj path dir)))))

(defn insert [v node]
  (if (nil? node)
    (singleton v)
    (let [cur-v (value node)
          dir (if (<= v cur-v) :left :right)
          next-node (dir node)]
      (assoc node dir (insert v next-node)))))

(defn to-list [{:keys [value left right] :as node}]
  (when node
    (lazy-cat (to-list left) [value] (to-list right))))

(defn from-list [[f & rs]]
  (reduce #(insert %2 %1) (singleton f) rs))

;;-----------------------------------

(defn insert- [v node]
  (apply assoc-in node (path-and-last-node v node [])))

(defn from-list- [[f & rs]]
  (reduce #(insert- %2 %1) (singleton f) rs))

(comment

  (time (let [r (from-list- (range 23603))]
          nil))

  (time (let [r (from-list (range 14752))]
          nil))

  (let [t (insert 2 (singleton 4))]
    [(= 4 (value t))
     (= 2 (value (left t)))])

  (let [t (insert 4 (singleton 4))]
    [(= 4 (value t))
     (= 4 (value (left t)))])

  (let [t (insert 5 (singleton 4))]
    [(= 4 (value t))
     (= 5 (value (right t)))])

  (let [t (from-list [4 2 6 1 3 7 5])]
    [(= 4 (value t))
     (= 2 (value (left t)))
     (= 1 (value (left (left t))))
     (= 3 (value (right (left t))))
     (= 6 (value (right t)))
     (= 5 (value (left (right t))))
     (= 7 (value (right (right t))))])


  (to-list (singleton 4))

  (to-list (from-list [4 2]))

  (to-list (from-list [4 5]))

  (to-list (from-list [4 2 1 3 6 7 5]))

  )