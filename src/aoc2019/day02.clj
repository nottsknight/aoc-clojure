(ns aoc2019.day02
  (:require [aoc.utils :refer [get-input-commas to-int]]))

(defn run-op [prog opr idx]
  (let [idx1 (aget prog (+ 1 idx))
        op1 (aget prog idx1)
        idx2 (aget prog (+ 2 idx))
        op2 (aget prog idx2)
        dest (aget prog (+ 3 idx))] 
    (aset-int prog dest (opr op1 op2))
    prog))

(defn run-intcode [idx prog]
  (case (aget prog idx)
    1 (->> (run-op prog + idx)
           (run-intcode (+ idx 4)))
    2 (->> (run-op prog * idx)
           (run-intcode (+ idx 4)))
    99 (aget prog 0)))

(defn part1 [file]
  (->> (get-input-commas file)
       (map to-int)
       (int-array)
       (fn [arr] ((aset-int arr 1 12)
                  (aset-int arr 2 2)
                  (run-intcode 0 arr)))))

(println (part1 "data/2019/day02.txt"))
