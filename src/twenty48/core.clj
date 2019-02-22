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

(def move-grid-left (partial map add-zeros-right-to-result))

(def move-grid-right (partial map add-zeros-left-to-result)


(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)

; ((partial map add) '((2 2) (2) (4) (2 2) (4 4)))
; (partial apply (partial mapcat split)) `((0 0 2 2) (0 2 0 4) (2 0 2 0) (0 4 4 0)))
; (move-grid-right `((0 0 2 2) (0 2 0 4) (2 0 2 0) (0 4 4 0)))
; (move-grid-left `((0 0 2 2) (0 2 0 4) (2 0 2 0) (0 4 4 0)))
