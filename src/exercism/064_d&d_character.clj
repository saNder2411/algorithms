(ns exercism.064-d&d-character
  (:require [clojure.math :as m]))

; source: https://exercism.org/tracks/clojure/exercises/dnd-character


(defn score-modifier [score]
  (int (m/floor (/ (- score 10) 2))))

(defn rand-ability []
  (+ 3 (rand-int 16)))

(defn rand-character []
  (let [constitution (rand-ability)]
    {:strength     (rand-ability)
     :dexterity    (rand-ability)
     :charisma     (rand-ability)
     :wisdom       (rand-ability)
     :intelligence (rand-ability)
     :constitution constitution
     :hitpoints    (+ (score-modifier constitution) 10)}))

(comment
  (score-modifier 3)
  (score-modifier 4)
  (score-modifier 5)
  (score-modifier 6)
  (score-modifier 7)
  (score-modifier 8)
  (score-modifier 9)
  (score-modifier 10)
  (score-modifier 11)
  (score-modifier 12)
  (score-modifier 13)
  (score-modifier 14)
  (score-modifier 15)
  (score-modifier 16)
  (score-modifier 17)
  (score-modifier 18)
  (rand-ability)
  (rand-character)

  )