(defn parting
  "returns a String parting in a given language"
  ([] (parting "World"))
  ([name] (parting name "en"))
  ([name language]
    ; condp is similar to a case statement in other languages.
    ; It is described in more detail later.
    ; It is used here to take different actions based on whether the
    ; parameter "language" is set to "en", "es" or something else.
    (condp = language
      "en" (str "Goodbye, " name)
      "es" (str "Adios, " name)
      (throw (IllegalArgumentException.
               (str "unsupported language " language))))))

(println (parting)) ; -> Goodbye, World
(println (parting "Mark")) ; -> Goodbye, Mark
(println (parting "Mark" "es")) ; -> Adios, Mark
;(println (parting "Mark", "xy"))



(def years [1940 1944 1961 1985 1987])
(def filterd (vector (filter (fn [year] (even? year)) years))) ; long way w/ named arguments -> (1940 1944)
(println  filterd)
(filter #(even? %) years) ; short way where % refers to the argume