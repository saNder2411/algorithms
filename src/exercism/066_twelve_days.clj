(ns exercism.066-twelve-days
  (:require [clojure.string :as s]))

; source: https://exercism.org/tracks/clojure/exercises/twelve-days




;;On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree.
;
;On the second day of Christmas my true love gave to me: two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the seventh day of Christmas my true love gave to me: seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the eleventh day of Christmas my true love gave to me: eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.
;
;On the twelfth day of Christmas my true love gave to me: twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.

(def days ["first" "second" "third" "fourth" "fifth" "sixth" "seventh" "eighth" "ninth" "tenth" "eleventh" "twelfth"])

(def gifts ["a Partridge in a Pear Tree"
            "two Turtle Doves" "three French Hens"
            "four Calling Birds"
            "five Gold Rings"
            "six Geese-a-Laying"
            "seven Swans-a-Swimming"
            "eight Maids-a-Milking"
            "nine Ladies Dancing"
            "ten Lords-a-Leaping"
            "eleven Pipers Piping"
            "twelve Drummers Drumming"])


(defn- n->gifts [n]
  (let [[f & rst] (take (inc n) gifts)]
    (if (< n 1)
      f
      (s/join ", " (reverse (cons (str "and " f) rst))))))

(defn- verse [n]
  (format "On the %s day of Christmas my true love gave to me: %s." (get days n) (n->gifts n)))

(defn recite [start-verse end-verse]
  (->> (range (dec start-verse) end-verse)
       (map verse)
       (s/join "\n")))

(comment

  (n->gifts 0)
  (recite 1 4)

  )
