(ns twenty48.core
  (:gen-class))

(def identical-partition (partial partition-by identity))

(def remove-zeros (partial remove zero?))

(def partition-by-2 (partial partition-all 2))

(def sanitize-lists (partial mapcat partition-by-2))

(def add-list-items (partial reduce +))

(def split-identical(comp identical-partition remove-zeros))

(def split (comp sanitize-lists split-identical))

(def add (partial map add-list-items))

(defn append
  [n coll]
  (concat coll (repeat (- n (count coll)) 0)))

(defn prepend
    [n coll]
    (concat (repeat (- n (count coll)) 0) coll))

(def append-four (partial append 4))

(def prepend-four (partial prepend 4))

(def add-row-items (comp add split))

(def reverse-list-items (partial map reverse))

(def add-zeros-right-to-result (comp append-four add-row-items))

(def add-zeros-left-to-result (comp prepend-four add-row-items))

(def cartesian (partial apply map vector))

(def move-grid-left (partial map add-zeros-right-to-result))

(def move-grid-right (partial map add-zeros-left-to-result))

(def move-grid-down (comp cartesian (partial move-grid-right) cartesian))

(def move-grid-up (comp cartesian (partial move-grid-left) cartesian))
