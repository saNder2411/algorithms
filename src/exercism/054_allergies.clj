(ns exercism.054-allergies)

; source: https://exercism.org/tracks/clojure/exercises/allergies

(def allergens {1   :eggs
                2   :peanuts
                4   :shellfish
                8   :strawberries
                16  :tomatoes
                32  :chocolate
                64  :pollen
                128 :cats})

(defn allergies [score]
  (loop [[fst & rst] (reverse (take-while #(<= % score) (iterate #(* % 2) 1)))
         sum score
         result '()]
    (cond (or (= sum 0) (nil? fst)) (remove nil? result)
          (< (- sum fst) 0) (recur rst sum result)
          :else (recur rst (- sum fst) (conj result (get allergens fst))))))

(defn allergic-to? [score allergen]
  (boolean (some #{allergen} (allergies score))))

;; -------------------------------------------------

(def a-vector [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats])

(defn allergies- [score]
  (keep-indexed #(when (bit-test score %1) %2) a-vector))

(defn allergic-to? [score allergen]
  (boolean (some #{allergen} (allergies- score))))

(comment
  (bit-test 2 1)
  (into {} (map-indexed vector a-vector))
  (map-indexed vector a-vector)

  (allergies 5)

  (allergic-to? 0 :eggs)
  (allergic-to? 1 :eggs)
  (allergic-to? 3 :eggs)
  (allergic-to? 2 :eggs)
  (allergic-to? 255 :eggs)
  (allergic-to? 0 :peanuts)
  (allergic-to? 2 :peanuts)
  (allergic-to? 7 :peanuts)
  (allergic-to? 5 :peanuts)
  (allergic-to? 255 :peanuts)
  (allergic-to? 0 :shellfish)
  (allergic-to? 4 :shellfish)
  (allergic-to? 14 :shellfish)
  (allergic-to? 10 :shellfish)
  (allergic-to? 255 :shellfish)
  (allergic-to? 0 :strawberries)
  (allergic-to? 8 :strawberries)
  (allergic-to? 28 :strawberries)
  (allergic-to? 20 :strawberries)
  (allergic-to? 255 :strawberries)
  (allergic-to? 0 :tomatoes)
  (allergic-to? 16 :tomatoes)
  (allergic-to? 56 :tomatoes)
  (allergic-to? 40 :tomatoes)
  (allergic-to? 255 :tomatoes)
  (allergic-to? 0 :chocolate)
  (allergic-to? 32 :chocolate)
  (allergic-to? 112 :chocolate)
  (allergic-to? 80 :chocolate)
  (allergic-to? 255 :chocolate)
  (allergic-to? 0 :pollen)
  (allergic-to? 64 :pollen)
  (allergic-to? 224 :pollen)
  (allergic-to? 160 :pollen)
  (allergic-to? 255 :pollen)
  (allergic-to? 0 :cats)
  (allergic-to? 128 :cats)
  (allergic-to? 192 :cats)
  (allergic-to? 64 :cats)
  (allergic-to? 255 :cats)

  (allergies- 0)
  (allergies- 1)
  (allergies- 2)
  (allergies 8)
  (allergies 3)
  (allergies 5)
  (allergies 248)
  (allergies 255)
  (allergies- 509)
  (allergies- 257)
  )