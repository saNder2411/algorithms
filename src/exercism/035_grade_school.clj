(ns exercism.035-grade-school)

; source: https://exercism.org/tracks/clojure/exercises/grade-school

(def db {})

(defn grade [school grade]
  (get school grade []))

(defn add [school name grade]
  (update school grade (comp vec conj) name))

(defn sorted [school]
  (into (sorted-map) (update-vals school (comp vec sort))))

(comment
  (add db "Aimee" 2)

  (-> db
      (add "James" 2)
      (add "Blair" 2)
      (add "Paul" 2))

  (-> db
      (add "Chelsea" 3)
      (add "Logan" 7))

  (-> db
      (add "Franklin" 5)
      (add "Bradley" 5)
      (add "Jeff" 1)
      (grade 5))

  (grade db 1)

  (-> db
      (add "Jennifer" 4)
      (add "Kareem" 6)
      (add "Christopher" 4)
      (add "Kyle" 3)
      (sorted))

  (-> db
      (add "Jennifer" 4)
      (add "Kareem" 6)
      (add "Christopher" 4)
      (add "Kyle" 3)
      (sorted)
      (keys))


  )