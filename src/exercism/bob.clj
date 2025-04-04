(ns exercism.bob
  (:require [clojure.string :as s]))

;; source: https://exercism.org/tracks/clojure/exercises/bob

(defn- has-letter? [msg] (some #(Character/isLetter (int %)) msg))

(defn- yell? [msg] (and (= msg (s/upper-case msg))
                        (has-letter? msg)))

(defn response-for [s]
  (let [clean-s (s/trim s)]
    (cond (empty? clean-s) "Fine. Be that way!"
          (and (s/ends-with? clean-s "?") (yell? clean-s)) "Calm down, I know what I'm doing!"
          (s/ends-with? clean-s "?") "Sure."
          (yell? clean-s) "Whoa, chill out!"
          :else "Whatever.")))

(comment
  (response-for "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")
  )