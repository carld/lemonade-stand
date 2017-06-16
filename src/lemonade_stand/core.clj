(ns lemonade-stand.core
  (:require [lemonade-stand.screen :as screen])
  (:gen-class))

(defn print-introduction []
  (screen/clear)
  (screen/move-top)
  (println "Lemonade Stand")
  (println "")
  (println "Hi! Would you like to start a new game? (yes or no)")
  )

(defn start-game-question []
  (loop []
    (println "Type your answer and hit return ==>")
    (let [start-game (read-line)]
      (if (and (not (.startsWith start-game "y")) (not (.startsWith start-game "n")))
          (do (screen/bell) (recur))
          (println "we left the loop")))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print-introduction)
  (start-game-question)
  )
