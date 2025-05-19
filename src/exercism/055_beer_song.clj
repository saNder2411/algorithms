(ns exercism.055-beer-song)

; source: https://exercism.org/tracks/clojure/exercises/beer-song

(defn- first-row [n]
  (cond (> n 1) (format "%s bottles of beer on the wall, %s bottles of beer.\n" n n)
        (= n 1) (format "%s bottle of beer on the wall, %s bottle of beer.\n" n n)
        :else "No more bottles of beer on the wall, no more bottles of beer.\n"))

(defn- second-row [n]
  (cond (> n 1) (format "Take one down and pass it around, %s bottles of beer on the wall.\n" n n)
        (= n 1) (format "Take one down and pass it around, %s bottle of beer on the wall.\n" n n)
        (= n 0) "Take it down and pass it around, no more bottles of beer on the wall.\n"
        :else "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))


(defn verse [num]
  (str (first-row num) (second-row (dec num))))

(defn sing
  ([start end]
   (->> (range start (dec end) -1)
        (map verse)
        (clojure.string/join "\n")))
  ([start] (sing start 0)))

(comment

  (verse 8)
  (verse 2)
  (verse 1)
  (verse 0)
  (sing 8 6)

  (sing 3)
  )