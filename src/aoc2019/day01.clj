(ns aoc2019.day01
  (:require [aoc.utils :refer [get-input-lines to-int sum]])
  (:require [clojure.math :refer [floor-div]]))

(defn fuel-req [mass]
  (- (floor-div mass 3) 2))

(defn fuel-for-fuel [fuel]
  (let [fuel2 (fuel-req fuel)]
    (if (<= fuel2 0)
      0
      (+ fuel2 (fuel-for-fuel fuel2)))))

(defn part1 [file]
  (->> (get-input-lines file)
       (map to-int)
       (map fuel-req)
       (sum)))

(defn part2 [file]
  (->> (get-input-lines file)
       (map to-int)
       (map fuel-req)
       (map (fn [f] (+ f (fuel-for-fuel f))))
       (sum)))

(println (part1 "data/2019/day01.txt"))
(println (part2 "data/2019/day01.txt"))
