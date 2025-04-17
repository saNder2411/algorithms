(ns leet-code.295-find-median-from-data-stream)

;; source: https://leetcode.com/problems/find-median-from-data-stream/description/


;; Leet-code reference: https://leetcode.com/problems/find-median-from-data-stream/description/

;; Find Median from Data Stream
;; The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
;For example, for arr = [2,3,4], the median is 3.
;For example, for arr = [1,2,3,10], the median is (2 + 3) / 2 = 2.5.

;; ADD:
;; if left heap is empty or peek of left heap is > num - add to left heap
;; else add to the right heap
;;
;; handle imbalances: if left size - right size > 1, move peek element from left to right
;; if opposite keep as is

;; MEDIAN:
;; if both heaps are empty - nil
;; if one is > the other - peek from the bigger heap
;; else get average from both heaps
;;
;;

;; HEAPS
;; Complete Binary Tree: A min-heap is a complete binary tree, meaning all levels of the tree are fully filled except possibly the last level, which is filled from left to right.
;
;Min-Heap Property: For every node i, the value of i is less than or equal to the values of its children. This guarantees that the minimum element is at the root of the heap.
;
;Efficient Operations: Common operations such as inserting an element or removing the minimum element are efficient. These operations have a time complexity of O(log n), where n is the number of elements in the heap.


(defn median-finder []
  (let [left (atom '())
        right (atom [])
        num-transfer (fn [col-in col-out]
                       (swap! col-in conj (first @col-out))

                       (if (vector? @col-out)
                         (reset! col-out (vec (rest @col-out)))
                         (reset! col-out (rest @col-out))))]
    {:add-num     (fn [n]
                    (if (or (empty? @left) (< n (first @left)))
                      (swap! left conj n)
                      (swap! right conj n))

                    (let [ls (count @left)
                          rs (count @right)]
                      (cond
                        (> (- ls rs) 1) (num-transfer right left)
                        (> (- rs ls) 1) (num-transfer left right))))
     :find-median (fn []
                    (let [ls (count @left)
                          rs (count @right)
                          l (first @left)
                          r (first @right)]
                      (cond (= ls rs 0) nil
                            (> ls rs) (double l)
                            (> rs ls) (double r)
                            :else (/ (+ l r) 2.0))))
     :print-s     (fn []
                    (println "l" @left)
                    (println "r" @right)
                    (println "---------------"))}))

(comment
  (let [{:keys [add-num find-median print-s]} (median-finder)]
    (println "empty?" (nil? (find-median)))
    (add-num 1)
    (add-num 2)
    (println "res:" (find-median))
    (print-s)
    (add-num 3)
    (println "res:" (find-median))
    (print-s)
    (add-num 4)
    (println "res:" (find-median))
    (print-s)
    (add-num 5)
    (println "res:" (find-median))
    (print-s)
    (add-num 6)
    (println "res:" (find-median))
    (print-s)
    (add-num 7)
    (println "res:" (find-median))
    (print-s)
    (add-num 8)
    (println "res:" (find-median))
    (print-s))
  )