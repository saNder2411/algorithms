(ns exercism.062-phone-number)

; source: https://exercism.org/tracks/clojure/exercises/phone-number

(def invalid-template "0000000000")

(defn- check-11-digit-number [t]
  (if (and (= (count t) 11) (= \1 (first t)))
    (apply str (rest t))
    t))

(defn check-10-digit-number- [t]
  (let [[c-fst _ _ e-fst] t]
    (cond (not= (count t) 10) invalid-template
          (or (= \0 c-fst) (= \1 c-fst)) invalid-template
          (or (= \0 e-fst) (= \1 e-fst)) invalid-template
          :else t)))


(defn check-10-digit-number [t]
  (if (re-matches #"[2-9]\d{2}[2-9]\d{6}" t)
    t
    invalid-template))

(defn number [s]
  (->> s
       (re-seq #"\d")
       (apply str)
       check-11-digit-number
       check-10-digit-number))


(comment
  (vld "2234561890")
  (number "(223) 456-7890")
  (number "223.456.7890")
  (number "223 456   7890   ")
  (number "123456789")
  (number "22234567890")
  (number "12234567890")
  (number "+1 (223) 456-7890")
  (number "321234567890")
  (number "523-abc-7890")
  (number "523-@:!-7890")
  (number "(023) 456-7890")
  (number "(123) 456-7890")
  (number "(223) 056-7890")
  (number "(223) 156-7890")
  (number "1 (023) 456-7890")
  (number "1 (123) 456-7890")
  (number "1 (223) 056-7890")
  (number "1 (223) 156-7890")
  )

