(ns lemonade-stand.screen
  (:gen-class))

(defn clear []
  (print (str (char 27) "[2J")))

(defn move-top []
  (print (str (char 27) "[;H")))

(defn bell []
  (print (str (char 7))))
