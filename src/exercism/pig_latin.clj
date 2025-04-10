(ns exercism.pig-latin
  (:require [clojure.string :as s]))

;; source: https://exercism.org/tracks/clojure/exercises/pig-latin

(def vowels_? #{\a \e \i \o \u})

(defn not-vowels? [vowels-set c]
  (not (vowels-set c)))

(defn- add-ay [w] (str w "ay"))

(defn- validate-1 [[l l1]]
  (or (vowels_? l) (= (str l l1) "xr") (= (str l l1) "yt")))

(defn- validate-2 [[l]]
  (not (vowels_? l)))

(defn- validate-3 [[l l1 l2 l3]]
  (or (= (str l l1) "qu")
      (= (str l1 l2) "qu")
      (= (str l2 l3) "qu")))

(defn- validate-4 [[l l1 l2]]
  (or (and (not (vowels_? l)) (= l1 \y))
      (and (not (vowels_? l)) (not (vowels_? l1)) (= l2 \y))))

(defn- consonants-from-start->end [vowels-set word]
  (reduce (fn [res f]
            (apply str res (f #(not-vowels? vowels-set %) word))) "" [drop-while take-while]))

(defn- translate-word [w]
  (cond (validate-1 w) (add-ay w)
        (validate-4 w) (->> w (consonants-from-start->end (conj vowels_? \y)) add-ay)
        (validate-3 w) (->> w (consonants-from-start->end (disj vowels_? \u)) add-ay)
        (validate-2 w) (->> w (consonants-from-start->end vowels_?) add-ay)
        :else w))

(defn translate- [phrase]
  (s/join " " (map translate-word (s/split phrase #" "))))

;; -------------------------------------------------


(def vowels? (set "aeiou"))

(def consonant? (complement vowels?))

(def ny-cons? (every-pred consonant? (partial not= \y)))

(defn- vowely? [s]
  (some (partial s/starts-with? s) ["xr" "yt"]))

(defn- y-first? [s]
  (= \y (first s)))

(defn- qu-after-cc? [cc rst]
  (and (= \q (last cc)) (= \u (first rst))))

(defn- split-cons [s]
  (let [[cc rst] (split-with ny-cons? s)]
    (cond (vowely? s) [s]
          (y-first? s) [(rest s) "y"]
          (qu-after-cc? cc rst) [(rest rst) cc "u"]
          :else [rst cc])))

(defn- pigify [s]
  (->> "ay"
       (conj (split-cons s))
       flatten
       (apply str)))

(defn translate [phrase]
  (->> (s/split phrase #" ")
       (map pigify)
       (s/join " ")))


(comment
  (translate "apple")
  (translate "xray")
  (translate "yttria")
  (translate "pig")
  (translate "chair")
  (translate "thrush")
  (translate "quick")
  (translate "square")
  (translate "my")
  (translate "rhythm")
  (translate "yellow")
  (translate "quick fast run")

  )