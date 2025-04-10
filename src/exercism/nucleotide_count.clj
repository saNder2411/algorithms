(ns exercism.nucleotide-count)

;; source: https://exercism.org/tracks/clojure/exercises/nucleotide-count

(def nucleotides #{\A \C \G \T})

(def default-count
  (zipmap nucleotides (repeat 0)))

(defn nucleotide-counts [strand]
  (into default-count (frequencies strand)))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (or ((nucleotide-counts strand) nucleotide)
      (throw (Exception. "invalid strand"))))

(comment
  (count-of-nucleotide-in-strand \A "")
  (count-of-nucleotide-in-strand \C "CCCCC")
  (count-of-nucleotide-in-strand \T "GGGGGTAACCCGG")
  (count-of-nucleotide-in-strand \X "GACT")
  (nucleotide-counts "")
  (nucleotide-counts "GGGGGGGG")
  (nucleotide-counts "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
  )