(ns exercism.063-atbash-cipher
  (:require [clojure.string :as s]))

; source: https://exercism.org/tracks/clojure/exercises/atbash-cipher


(def nums (mapv #(str (char %)) (range 48 58)))

(def a-z (mapv #(str (char %)) (range 97 123)))

(def z-a (mapv #(str (char %)) (range 122 96 -1)))

(def code-map (into (zipmap nums nums) (zipmap a-z z-a)))

(defn encode [plaintext]
  (->> plaintext
       (s/lower-case)
       (re-seq #"[a-z0-9]")
       (map code-map)
       (partition-all 5)
       (map #(apply str %))
       (s/join " ")))

(defn decode [ciphertext]
  (->> ciphertext
       (re-seq #"[a-z0-9]")
       (map code-map)
       (apply str)))


(comment
(code-map "a" "a")

  (encode "yes")
  (encode "no")
  (encode "OMG")
  (encode "O M G")
  (encode "mindblowingly")
  (encode "Testing,1 2 3, testing.")
  (encode "Truth is fiction.")
  (encode "The quick brown fox jumps over the lazy dog.")
  (decode "vcvix rhn")
  (decode "zmlyh gzxov rhlug vmzhg vkkrm thglm v")
  (decode "gvhgr mt123 gvhgr mt")
  (decode "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt")

  )