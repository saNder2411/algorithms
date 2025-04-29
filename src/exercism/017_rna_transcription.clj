(ns exercism.017-rna-transcription)

; source: https://exercism.org/tracks/clojure/exercises/rna-transcription

(def rna-map {\G \C
              \C \G
              \T \A
              \A \U})

(defn to-rna [dna]
  (apply str (map rna-map dna)))


(comment
  (to-rna "")
  (to-rna "C")
  (to-rna "G")
  (to-rna "T")
  (to-rna "A")
  (to-rna "ACGTGGTCTTAA")
  )