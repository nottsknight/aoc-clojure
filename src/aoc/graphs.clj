(ns aoc.graphs
  (:gen-class))

(defrecord Graph [edges])

(defn new-graph []
  (Graph. (hash-map)))

(defn has-vertex? [graph vertex]
  (contains? (:edges graph) vertex))

(defn neighbours [graph vertex]
  (get (:edges graph) vertex))

(defn has-edge? [graph src dest]
  (if-not (has-vertex? graph src)
    false
    (contains? (neighbours graph src) dest)))

(defn add-vertex [graph v]
  (->> (hash-set)
       (assoc (:edges graph) v)
       (assoc graph :edges)))

(defn add-edge [graph src dest]
  (if-not (has-vertex? graph src)
    (throw (IllegalArgumentException. 
             (format "Cannot create edge, src vertex %s does not exist" src)))
    (let [edges (neighbours graph src)]
      (->> (conj edges dest)
           (assoc (:edges graph) src)
           (assoc graph :edges)))))

(defn add-edge-undirected [graph v1 v2]
  (-> graph
      (add-edge v1 v2)
      (add-edge v2 v1)))
