(ns aoc2023.day01
  (:require [aoc.utils :refer [get-input-lines sum]])
  (:require [clojure.string :as string]))

(defn get-digits [string]
  (filter #(Character/isDigit %) string))

(defn chars-to-ints [chars]
  (map #(Character/digit % 10) chars))

(defn calibration-value [chars]
  (+ (* 10 (first chars)) (last chars)))

(defn replace-digit-words [str]
  (-> str
      (string/replace "one" "1")
      (string/replace "two" "2")
      (string/replace "three" "3")
      (string/replace "four" "4")
      (string/replace "five" "5")
      (string/replace "six" "6")
      (string/replace "seven" "7")
      (string/replace "eight" "8")
      (string/replace "nine" "9")))

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

