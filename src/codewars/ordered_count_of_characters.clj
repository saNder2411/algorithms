(ns codewars.ordered-count-of-characters)

;; source: https://www.codewars.com/kata/57a6633153ba33189e000074/clojure

(defn ordered-count [s]
  (->> s
       (reduce (fn [{:keys [cache res] :as acc} ch]
                 (if (nil? (get cache ch))
                   (let [i (count res)]
                     (-> acc
                         (assoc-in [:cache ch] i)
                         (assoc-in [:res i] [ch 1])))
                   (let [i (get cache ch)]
                     (update-in acc [:res i 1] inc))))
               {:cache {} :res []})
       :res))

(defn ordered-count-1 [string]
  (map
    (juxt identity (frequencies string))
    (distinct string)))

(defn ordered-count-2 [string]
  (let [frq (frequencies string)]
    (map (fn [c] (list c (get frq c)))
         (distinct string))))
(comment
  (ordered-count "abracadabra")
  (ordered-count "Code Wars")

  (ordered-count-1 "abracadabra")
  (ordered-count-1 "Code Wars")

  (ordered-count-2 "abracadabra")
  (ordered-count-2 "Code Wars")
  )



