(ns exercism.058-rotational-cipher)

; source: https://exercism.org/tracks/clojure/exercises/rotational-cipher

(defn- shift-idx [start-idx ch-idx shift]
  (let [shifted-idx (+ ch-idx shift)]
    (+ start-idx (mod (- shifted-idx start-idx) 26))))

(defn- rotate-cipher [key ch]
  (let [ch-idx (int ch)]
    (cond (< 96 ch-idx 123) (char (shift-idx 97 ch-idx key))
          (< 64 ch-idx 91) (char (shift-idx 65 ch-idx key))
          :else ch)))

(defn rotate [msg key]
  (->> msg
       (map (partial rotate-cipher key))
       (apply str)))


(comment

  (map char (range 97 123))

  (rotate "a" 0)
  (rotate "a" 1)
  (rotate "a" 26)
  (rotate "m" 13)
  (rotate "n" 13)
  (rotate "OMG" 5)
  (rotate "O M G" 5)
  (rotate "Testing 1 2 3 testing" 4)
  (rotate "Let's eat, Grandma!" 21)
  (rotate "The quick brown fox jumps over the lazy dog." 13)

  )
