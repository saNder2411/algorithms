(ns exercism.057-secret-handshake)

; source: https://exercism.org/tracks/clojure/exercises/secret-handshake

(def msgs ["wink" "double blink" "close your eyes" "jump" "reverse"])

(defn- revers-cmds [cmds]
  (if (= (last cmds) "reverse")
    (reverse (butlast cmds))
    cmds))

(defn commands_ [n]
  (->> (range 5)
       (filter #(bit-test n %))
       (map #(get msgs %))
       revers-cmds))

(defn commands [n]
  (->> ["wink" "double blink" "close your eyes" "jump" reverse]
       (map-indexed vector)
       (reduce
         (fn [acc [idx c]]
           (let [f (if (string? c) #(conj % c) c)]
             (cond-> acc
                     (bit-test n idx) f)))
         [])))

(comment

  (commands 9)

  (commands 26)
  )
