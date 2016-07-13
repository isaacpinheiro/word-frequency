(ns word-frequency.core
    (require [word-frequency.parser :as parser])
    (:gen-class))

(defn -main [& args]

    (println)
    (println "########## Word Frequency ##########")
    (println)
    (println "Please, inform some text: ")
    (println)
    (def text (read-line))
    (println)

    (def wordFrequency
        (parser/transform
            (parser/group
                (parser/toList text))))

    (loop [v wordFrequency]
        (if (not= v [])
            (do
                (def wf (first v))
                (def res (str "Word: " (wf :word) ", Frequency: " (wf :frequency)))
                (println res)
                (recur (rest v))))))

