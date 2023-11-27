(ns aoc.intcode)

(defstruct int-machine :memory :inst-ptr)

(defn make-int-machine [prog]
  (struct int-machine prog 0))

(defn run-inst [machine]
  (let [ip (get machine :inst-ptr)
        mem (get machine :memory)]
    (case (aget mem ip)
      1 1 
      2 2 
      99 (aget mem 0))))
