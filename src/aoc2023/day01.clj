(ns aoc2023.day01
  (:require [aoc.utils :refer [get-input-lines sum]])
  (:require [clojure.string :as string]))

(defn get-digits [string]
  (filter #(Character/isDigit %) string))

(defn chars-to-ints [chars]
  (map #(Character/digit % 10) chars))

(defn calibration-value [chars]
  (+ (* 10 (first chars)) (last chars)))

(defn replace-digit-word [^String instr]
  (cond
    (string/starts-with? instr "one") [\1 2]
    (string/starts-with? instr "two") [\2 2]
    (string/starts-with? instr "three") [\3 4]
    (string/starts-with? instr "four") [\4 3]
    (string/starts-with? instr "five") [\5 3]
    (string/starts-with? instr "six") [\6 2]
    (string/starts-with? instr "seven") [\7 4]
    (string/starts-with? instr "eight") [\8 4]
    (string/starts-with? instr "nine") [\9 3]
    :else [(first instr) 1]))

(defn replace-digit-words [^String instr]
  (if (empty? instr)
    ""
    (let [[c w] (replace-digit-word instr)
          str1 (apply str (drop w instr))]
      (cons c (replace-digit-words str1)))))

(defn part1 [file]
  (->> (get-input-lines file)
       (map get-digits)
       (map #(vector (first %) (last %)))
       (map chars-to-ints)
       (map calibration-value)
       (sum)))

(defn part2 [file]
  (->> (get-input-lines file)
       (map replace-digit-words)
       (map get-digits)
       (map #(vector (first %) (last %)))
       (map chars-to-ints)
       (map calibration-value)
       (sum)))

(println (part1 "data/2023/day01.txt"))
(println (part2 "data/2023/day01.txt"))

