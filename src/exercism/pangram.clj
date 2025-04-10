(ns exercism.pangram)

;; source: https://exercism.org/tracks/clojure/exercises/pangram

(def default-count (zipmap (map char (range (int \a) (inc (int \z)))) (repeat 0)))

(defn pangram? [s]
  (let [fr (frequencies (clojure.string/lower-case s))
        res (into default-count fr)]
    (every? (fn [[_ v]] (< 0 v)) res)))

(comment
  (pangram? "")
  (pangram? "abcdefghijklmnopqrstuvwxyz")
  (pangram? "the quick brown fox jumps over the lazy dog")
  (pangram? "a quick movement of the enemy will jeopardize five gunboats")
  (pangram? "five boxing wizards jump quickly at it")
  (pangram? "the_quick_brown_fox_jumps_over_the_lazy_dog")
  (pangram? "the 1 quick brown fox jumps over the 2 lazy dogs")
  (pangram? "7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog")
  (pangram? "\"Five quacking Zephyrs jolt my wax bed.\"")
  (pangram? "abcdefghijklm ABCDEFGHIJKLM")

  )