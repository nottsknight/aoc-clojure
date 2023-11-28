(ns aoc.graphs
  (:require [clojure.core.matrix :as ccm])
  (:gen-class))

(defrecord Graph [vertices adj-matrix])

(defn new-graph [vertices]
  (let 
    [data (for [_ vertices] (for [_ vertices] nil))]
    (Graph. vertices (ccm/matrix data))))

(defn- edge-index [graph v]
  (.indexOf (:vertices graph) v))

(defn set-edge [graph src dest w]
  (let [m (:adj-matrix graph)
        i (edge-index graph src)
        j (edge-index graph dest)]
    (->> (ccm/mset m i j w)
         (assoc graph :adj-matrix))))

(defn get-edge [graph src dest]
  (if (= src dest)
    0
    (let [i (edge-index graph src)
          j (edge-index graph dest)]
      (ccm/mget (:adj-matrix graph) i j))))

(defn has-edge? [graph src dest]
  (not= (get-edge graph src dest) nil))

(defn neighbours [graph v]
  (for [v1 (:vertices graph) 
        :when (and
                (not= v v1) 
                (has-edge? graph v v1))] 
    v1))
