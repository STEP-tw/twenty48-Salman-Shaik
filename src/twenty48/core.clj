(ns twenty48.core
  (:gen-class))

(def split-identical
  (
    comp (partial partition-by identity) (partial remove zero?)
  )
)

(def split
  (
    comp (partial mapcat (partial partition-all 2)) split-identical
  )
)

(def add (partial map (partial reduce +)))

(defn append
  [n coll]
  (take n (concat coll (repeat n 0))))

(defn prepend
  [n coll]
  (reverse (append n (reverse coll))))

(def move-grid-right (partial map (comp (partial prepend 4) add split)))

(def move-grid-left (partial map (comp (partial append 4) add split)))

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
