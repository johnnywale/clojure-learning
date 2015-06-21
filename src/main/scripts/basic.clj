(in-ns 'user)

(defn hello [name]
  (println "hello" name))

(hello "dfaf")


(def vowel? (set "aeiou"))

(defn pig-latin [word]
  (let [first-letter (first word)]
    (if (vowel? first-letter)
      (str word "ay")
      (str (subs word 1) first-letter "ay")

      ))

  )
(println (pig-latin "red"))
(println (pig-latin "orange"))

(def v 1) ; v is a global binding

(defn f1 []
  (println "f1: v =" v)) ; global binding

(defn f2 []
  (println "f2: before let v =" v) ; global binding
  (let [v 2] ; creates local binding v that shadows global one
    (println "f2: in let, v =" v) ; local binding
    (f1))
  (println "f2: after let v =" v)) ; global binding

(defn f3 []
  (println "f3: before binding v =" v) ; global binding
  (binding [v 3] ; same global binding with new, temporary value
    (println "f3: in binding, v =" v) ; global binding
    (f1))
  (println "f3: after binding v =" v)) ; global binding

(defn f4 []
  (def v 4)) ; changes the value of the global binding

;(f2)
;(f3)
;(f4)
(println "after calling f4, v =" v)


(println (count [19 "yellow" true]))
(println (reverse [2 4 7]))
(println (map + [2 4 7] [5 6] [1 2 3 4]))
(println (map #(+ % 1) (map #(/ % 3) [1 2 3])))

(def stooges ["Moe" "Larry" "Curly" "Shemp"])
(first stooges) ; -> "Moe"
(second stooges) ; -> "Larry"
(last stooges) ; -> "Shemp"
(nth stooges 2) ; indexes start at 0 -> "Curly"

(next stooges) ; -> ("Larry" "Curly" "Shemp")
(butlast stooges) ; -> ("Moe" "Larry" "Curly")
(drop-last 2 stooges) ; -> ("Moe" "Larry")
; Get names containing more than three characters.
(filter #(> (count %) 3) stooges) ; -> ("Larry" "Curly" "Shemp")
(nthnext stooges 2) ; -> ("Curly" "Shemp")

(println (apply + [2 4 7]))


(def stooges (list "Moe" "Larry" "Curly")) ; list
(def stooges (quote ("Moe" "Larry" "Curly"))) ; list
(def stooges '("Moe" "Larry" "Curly")) ; list


;(some #(= % "Moe") stooges) ; -> true
;(some #(= % "Mark") stooges) ; -> nil

(println (contains? (set stooges) "Moe")) ; convert to list set and use contains

(def conbined_list (into (list "aa" "bb" "cc") (list "dd" "ee" "ff")))
(println (reverse conbined_list))

(def may_be "fff")

(println (get ["AAA" "BB" "DDD" may_be] 1 "unknown")) ; get only work  for vector

(println (get ["AAA" "BB" "DDD" may_be] 10 "unknown")) ; get only work  for vector


(def simple_set #{"ab","ac","ae"})
(println (simple_set "ab") (simple_set "aaa"))

(println (if (nil? (simple_set "aaa")) "abbb" "dff"))

(def popsicle-map
  (hash-map :red "cherry", :green :apple , :purple :grape))
(def popsicle-map
  {:red :cherry, :green :apple, :purple :grape}) ; same as previous
(def popsicle-map
  (sorted-map :red "cherry", :green :apple , :purple :grape))

(println (contains? popsicle-map :red))
(println (some #{"cherry"} (vals popsicle-map)))
(println (vals popsicle-map))
(println (contains? (set (vals popsicle-map)) "cherry"))
(def person {
              :name "Mark Volkmann"
              :address {
                         :street "644 Glen Summit"
                         :city "St. Charles"
                         :state "Missouri"
                         :zip 63304}
              :employer {
                          :name "Object Computing, Inc."
                          :address {
                                     :street "12140 Woodcrest Executive Drive, Suite 250"
                                     :city "Creve Coeur"
                                     :state "Missouri"
                                     :zip 63141}}})




(println(get-in person [:employer :address :city]))
(-> person :employer :address :city) ; explained below
(reduce get person [:employer :address :city]) ; explained below

(println (reduce +  '(1 2 3) )   )


(def vehicle-struct (create-struct :make :model :year :color)) ; long way
(defstruct vehicle-struct :make :model :year :color) ; short way

(def vehicle (struct vehicle-struct "Toyota" "Prius" 2009,"RED"))



(def my (accessor vehicle-struct :make))
(println(my vehicle)) ; -> "Toyota"
(println(get-in vehicle [:make])) ; -> "Toyota"
(println (vehicle :make))






