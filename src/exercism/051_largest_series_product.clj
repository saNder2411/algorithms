(ns exercism.051-largest-series-product)

; source: https://exercism.org/tracks/clojure/exercises/largest-series-product

(defn- includes-letter [s]
  (boolean (re-find #"\p{L}" s)))

(defn largest-product [span s]
  (cond (neg? span) (throw (IllegalArgumentException. "span must not be negative"))
        (< (count s) span) (throw (IllegalArgumentException. "span must not exceed string length"))
        (includes-letter s) (throw (IllegalArgumentException. "digits input must only contain digits"))
        :else (->> s
                   (map #(^[char int] Character/digit % 10))
                   (partition span 1)
                   (map #(apply * %))
                   (apply max))))

(comment

  (includes-letter "12345")

  (largest-product 3 "63915")

  (largest-product 2 "29")

  (largest-product 2 "0123456789")

  (largest-product 2 "576802143")

  (largest-product 3 "0123456789")

  (largest-product 3 "1027839564")

  (largest-product 5 "0123456789")

  (largest-product 6 "73167176531330624919225119674426574742355349194934")

  (largest-product 2 "0000")

  (largest-product 3 "99099")

  (largest-product 4 "123")

  (largest-product 1 "")

  (largest-product 2 "1234a5")

  (largest-product -1 "12345")
  )