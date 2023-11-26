(ns aoc.utils
  (:require [clojure.string :as str])
  (:gen-class))

(defn sum [nums] (reduce + nums))

(defn to-int [n] (Integer/parseInt n 10))

(defn get-input-lines [file]
  (str/split-lines (slurp file)))

(defn get-input-commas [file]
  (str/split (str/trim (slurp file)) #","))
