(ns exercism.bank-account)

; source: https://exercism.org/tracks/clojure/exercises/bank-account

(defn open-account [] (atom 0))

(defn close-account [account]
  (reset! account nil)
  account)

(defn get-balance [account] @account)

(defn update-balance [account sum]
  (swap! account + sum)
  account)

(comment
  (-> (open-account)
      (get-balance))

  (-> (open-account)
      (update-balance 10)
      (get-balance))

  (let [account (open-account)]
    (println (get-balance account))
    (update-balance account 10)
    (println (get-balance account))
    (update-balance account -10)
    (println (get-balance account)))

  (let [account (open-account)]
    (close-account account)
    (get-balance account))

  (let [account (open-account)
        add-10 #(update-balance account 10)]
    (doall (pcalls add-10 add-10 add-10 add-10 add-10))
    (get-balance account))
  )