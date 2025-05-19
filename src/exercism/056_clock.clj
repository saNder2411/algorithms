(ns exercism.056-clock)

; source: https://exercism.org/tracks/clojure/exercises/clock


(def min-in-day (* 24 60))

(defn- minutes->h-m [m]
  ((juxt #(quot % 60) #(mod % 60)) (mod m min-in-day)))

(defn clock->string [[h m]]
  (format "%02d:%02d" h m))

(defn clock [h m]
  (minutes->h-m (+ (* h 60) m)))

(defn add-time [[h m] time]
  (clock h (+ m time)))


(comment
  (clock 0 160)
  (clock 8 0)
  (clock->string (clock 8 0))
  (clock->string (clock 11 9))
  (clock->string (clock 24 0))
  (clock->string (clock 25 0))
  (clock->string (clock 100 0))
  (clock->string (clock 1 60))
  (clock->string (clock 0 160))
  (clock->string (clock 0 1723))
  (clock->string (clock 25 160))
  (clock->string (clock 201 3001))
  (clock->string (clock 72 8640))
  (clock->string (clock -1 15))
  (clock->string (clock -25 0))
  (clock->string (clock -91 0))
  (clock->string (clock 1 -40))
  (clock->string (clock 1 -160))
  (clock->string (clock 1 -4820))
  (clock->string (clock -25 -160))
  (clock->string (clock -121 -5810))


  (clock->string (add-time (clock 10 0) 3))
  (clock->string (add-time (clock 6 41) 0))
  (clock->string (add-time (clock 0 45) 40))
  (clock->string (add-time (clock 10 0) 61))
  (clock->string (add-time (clock 0 45) 160))
  (clock->string (add-time (clock 23 59) 2))
  (clock->string (add-time (clock 5 32) 1500))
  (clock->string (add-time (clock 1 1) 3500))
  (clock->string (add-time (clock 10 3) -3))
  (clock->string (add-time (clock 10 3) -30))
  (clock->string (add-time (clock 10 3) -70))
  (clock->string (add-time (clock 0 3) -4))
  (clock->string (add-time (clock 0 0) -160))
  (clock->string (add-time (clock 6 15) -160))
  (clock->string (add-time (clock 5 32) -1500))
  (clock->string (add-time (clock 2 20) -3000))


  (let [clock1 (clock 15 37)
        clock2 (clock 15 37)]
    (= clock1 clock2))

  (let [clock1 (clock 15 36)
        clock2 (clock 15 37)]
    (not= clock1 clock2))

  (let [clock1 (clock 14 37)
        clock2 (clock 15 37)]
    (not= clock1 clock2))

  (let [clock1 (clock 10 37)
        clock2 (clock 34 37)]
    (= clock1 clock2))

  (let [clock1 (clock 3 11)
        clock2 (clock 99 11)]
    (= clock1 clock2))

  (let [clock1 (clock 22 40)
        clock2 (clock -2 40)]
    (= clock1 clock2))

  (let [clock1 (clock 17 3)
        clock2 (clock -31 3)]
    (= clock1 clock2))

  (let [clock1 (clock 13 49)
        clock2 (clock -83 49)]
    (= clock1 clock2))

  (let [clock1 (clock 0 1)
        clock2 (clock 0 1441)]
    (= clock1 clock2))

  (let [clock1 (clock 2 2)
        clock2 (clock 2 4322)]
    (= clock1 clock2))

  (let [clock1 (clock 2 40)
        clock2 (clock 3 -20)]
    (= clock1 clock2))

  (let [clock1 (clock 4 10)
        clock2 (clock 5 -1490)]
    (= clock1 clock2))

  (let [clock1 (clock 6 15)
        clock2 (clock 6 -4305)]
    (= clock1 clock2))

  (let [clock1 (clock 7 32)
        clock2 (clock -12 -268)]
    (= clock1 clock2))

  (let [clock1 (clock 18 7)
        clock2 (clock -54 -11513)]
    (= clock1 clock2))
  )