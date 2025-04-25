(ns exercism.isogram
  (:require [clojure.string :as s]))

; source: https://exercism.org/tracks/clojure/exercises/isogram

(defn isogram? [string]
  (if (empty? string)
    true
    (->> string
         s/lower-case
         (re-seq #"[a-zA-Z]")
         (apply distinct?))))

(comment
  (isogram? "")
  (isogram? "isogram")
  (isogram? "eleven")
  (isogram? "zzyzx")
  (isogram? "subdermatoglyphic")
  (isogram? "Alphabet")
  (isogram? "alphAbet")
  (isogram? "thumbscrew-japingly")
  (isogram? "thumbscrew-jappingly")
  (isogram? "six-year-old")
  (isogram? "Emily Jung Schwartzkopf")
  (isogram? "accentor")
  (isogram? "up-to-date")
  )
