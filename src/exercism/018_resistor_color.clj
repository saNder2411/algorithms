(ns exercism.018-resistor-color)

;; source: https://exercism.org/tracks/clojure/exercises/resistor-color

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn color-code [color]
  (first (keep-indexed  #(when (= color %2) %1) colors)))

(comment
  (color-code "")
  (color-code "black")
  (color-code "white")
  (color-code "orange")
  )