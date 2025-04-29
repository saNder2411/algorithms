(ns exercism.009_squeaky-clean
  (:require [clojure.string :as str]))

;; source: https://exercism.org/tracks/clojure/exercises/squeaky-clean

(defn letters [s]
  (apply str (filter #(or (Character/isLetter %) (= \_ %)) s)))

(defn escape-ctrl-char [c]
  (if (Character/isISOControl c) "CTRL" c))

(defn escape-ctrl [s]
  (apply str (map escape-ctrl-char s)))

(defn camelize [s]
  (let [words (str/split s #"-")]
    (if-not (str/includes? s "-")
      s
      (str/join (cons (first words)
                      (cons (str/upper-case (ffirst (rest words)))
                            (nfirst (rest words))))))))

(defn clean-greek [s]
  (apply str (filter #(not (<= 945 (int %) 969)) s)))

(defn clean [s]
  (-> s
      (str/replace " " "_")
      camelize
      escape-ctrl
      letters
      clean-greek))

(defn clean-1 [s]
  (-> s
      (str/replace #"\s" "_")                               ;task 1
      (str/replace #"\p{Cc}" "CTRL")                        ;task 2
      (str/replace #"-(\p{L})" #(str/upper-case (%1 1)))    ;task 3
      (str/replace #"[^\p{L}_]|[α-ω]" "")))                 ;task 4,5