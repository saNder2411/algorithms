(ns exercism.leap)

;; source: https://exercism.org/tracks/clojure/exercises/leap

(defn leap-year? [year]
  (or (and (zero? (mod year 4)) (pos? (mod year 100)))
      (zero? (mod year 400))))

(comment
  (leap-year? 1997)
  (leap-year? 1900)
  (leap-year? 2000)
  (leap-year? 2015)
  (leap-year? 1970)
  (leap-year? 1996)
  (leap-year? 1960)
  (leap-year? 2100)
  (leap-year? 2400)
  (leap-year? 1800)

  )
