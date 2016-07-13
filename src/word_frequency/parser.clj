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

(defn exist [vec item]
    (loop [v vec]
        (cond
            (= v []) false
            (= (first v) item) true
            :else (recur (rest v)))))

(defn group [vec]

    (def words
        (reduce
            (fn [acc x]
                (if (= (exist acc x) false)
                    (conj acc x)
                    acc))
            [] vec))

    (def res (struct WordGroup words vec))

    res)

(defn transform [wordGroup]
    wordGroup)

