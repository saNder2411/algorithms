(ns exercism.050-gigasecond
  (:import [java.time LocalDateTime]))

; source: https://exercism.org/tracks/clojure/exercises/gigasecond

(defn- date->obj-date [y m d]
  (LocalDateTime/of y m d 0 0 0))

(def obj-date->vec-date (juxt #(.getYear %) #(.getMonthValue %) #(.getDayOfMonth %)))

(defn from [y m d]
  (-> (date->obj-date y m d)
      (.plusSeconds (Math/pow 10 9))
      (obj-date->vec-date)))

(comment
  (from 2011 4 25)

  (from 1977 6 13)

  (from 1959 7 19)
  )
