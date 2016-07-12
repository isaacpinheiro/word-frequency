(ns word-frequency.parser)

(defstruct WordGroup :words :wordList)
(defstruct WordFrequency :word :frequency)

(defn toList [text]

    (def lines (clojure.string/split text #"\n"))

    (def inlineWords
        (reduce
            (fn [acc x]
                (str acc " " x))
            "" lines))

    (def words
        (filterv
            (fn [x]
                (if (not= x "") x))
            (clojure.string/split inlineWords #" ")))

    (def res
        (mapv
            (fn [x] (clojure.string/lower-case x))
            words))

    res)

(defn group [vec]
    nil)

(defn transform [wordGroup]
    nil)
