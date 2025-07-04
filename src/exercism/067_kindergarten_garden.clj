(ns exercism.067-kindergarten-garden
  (:require [clojure.string :as s]))

;; source: https://exercism.org/tracks/clojure/exercises/kindergarten-garden

(def s->keyword (comp keyword s/lower-case))

(def kids (map s->keyword ["Alice" "Bob" "Charlie" "David" "Eve" "Fred"
                           "Ginny" "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"]))

(def plants {\G :grass \C :clover \R :radishes \V :violets})

(def map-plants (partial mapv plants))

(defn garden [s-data]
  (->> s-data
       s/split-lines
       (map (partial partition 2))
       (apply map (comp map-plants flatten vector))
       (zipmap kids)))

(comment
  (garden "RC\nGG")
  (garden "VC\nRC")
  (garden "VVCG\nVVRC")
  (garden "VVCCGG\nVVCCGG")
  (garden "VVCCGG\nVVCCGG")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  (garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
  )

