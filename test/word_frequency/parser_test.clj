(ns word-frequency.parser-test
    (require [clojure.test :refer :all]
        [word-frequency.parser :refer :all]))

(deftest parser-test

    (def lorem "empty\nempty empty Empty\nnot not\n\nnot\n\nnot not not")

    (testing "Transforms text in list and filters."
        (is (= (toList lorem) ["empty" "empty" "empty" "empty" "not" "not" "not" "not" "not" "not"])))

    (testing "Transforms it correctly."

        (def wordList (toList lorem))
        (def tuples 
            (transform 
                (group wordList)))

        (is (= tuples [{:word "empty", :frequency 4} {:word "not", :frequency 6}]))))

