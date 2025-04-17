(ns exercism.protein-translation)

;; source: https://exercism.org/tracks/clojure/exercises/protein-translation

(def codons-map {"AUG" "Methionine"
                 "UUU" "Phenylalanine"
                 "UUC" "Phenylalanine"
                 "UUA" "Leucine"
                 "UUG" "Leucine"
                 "UCU" "Serine"
                 "UCC" "Serine"
                 "UCA" "Serine"
                 "UCG" "Serine"
                 "UAU" "Tyrosine"
                 "UAC" "Tyrosine"
                 "UGU" "Cysteine"
                 "UGC" "Cysteine"
                 "UGG" "Tryptophan"
                 "UAA" "STOP"
                 "UAG" "STOP"
                 "UGA" "STOP"})

(defn- split-rna-by-3 [s]
  (if (zero? (count s))
    []
    (partition-all 3 s)))

(defn- codon-chars->str [chars]
  (apply str chars))

(defn- codon->amino [c]
  (get codons-map c))

(defn- codons->amino-acids [codons]
  (let [acids (->> codons
                   (map #(codon->amino (codon-chars->str %)))
                   (take-while #(not= % "STOP")))]
    (if (some nil? acids)
      (throw (IllegalArgumentException. "Invalid codon"))
      acids)))

(defn translate-rna [rna]
  (-> rna
      split-rna-by-3
      codons->amino-acids))


(comment

  (translate-rna "XYZ")

  )