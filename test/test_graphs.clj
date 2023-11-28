(ns test-graphs
  (:require [aoc.graphs :as gs])
  (:require [clojure.test :refer [is deftest run-tests]]))

(deftest test-add-vertex
  (let [G (gs/add-vertex (gs/new-graph) 1)]
    (is (gs/has-vertex? G 1))))

(deftest test-add-edge
  (let [G0 (gs/add-vertex (gs/new-graph) 1)
        G (gs/add-edge G0 1 2)]
    (is (gs/has-edge? G 1 2))))

(deftest test-add-edge-undirected
  (let [G0 (gs/add-vertex (gs/new-graph) 1)
        G1 (gs/add-vertex G0 2)
        G (gs/add-edge-undirected G1 1 2)]
    (is (gs/has-edge? G 1 2))
    (is (gs/has-edge? G 2 1))))

(run-tests)
