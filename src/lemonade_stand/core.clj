(ns lemonade-stand.core
  (:require [lemonade-stand.screen :as screen])
  (:gen-class))

(def day 0)
(def sky-color 0)
(def cost 0)

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

;;; Line 400
(defn weather-report []
 ;;; a random number from 0 to 0.999
  (set! sky-color (rand))
  (let []
    (cond
      (< 0.6 sky-color)  (set! sky-color 2)
      (< 0.8 sky-color)  (set! sky-color 10)
      :else (set! sky-color 7))

    (if (< 3 day)
      (set! sky-color 2))
    ))

;;; Line 15000
(defn weather-display []
  (screen/clear)
  (println "Weather Report")
  (case sky-color
    2  (println "   Sunny")
    7  (println "   Hot and dry")
    10 (println "   Cloudy")
    5  (println "   Thunderstorms")
    )
  (println "")
  (println "Press space to continue, escape to end")
  (loop []
    (let [in (read-line)]
      (if (and (not (.startsWith in " ")) (not (.startsWith in 27)))
        (recur))
      ))
  )

;;; Line 500
(defn start-of-new-day []
  (set! day (+ 1 day))
  (format "On day ~d, the cost of lemonade is ")
  (set! cost 2)
  (if (> 2 day)
    (set! cost 4))
  (if (> 6 day)
    (set! cost 5))
  (format "$0.0%d" cost)

  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print-introduction)
  (start-game-question)
  )
