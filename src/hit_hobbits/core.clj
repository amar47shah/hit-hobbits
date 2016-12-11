(ns hit-hobbits.core
  (:gen-class))

; > (-main 3)
;   Hit you in the right knee!
;   Hit you in the left achilles!
;   Hit you in the back!
;   I think you've had enough.
; => nil

(defn hit
  "Expects a nested map with int keys pointing to maps of :name and :size,
  and a :max key indicating the smallest strict upper bound of int keys"
  [available-targets]
  (let
    [strict-upper-bound (available-targets :max)
     random-target-value (rand-int strict-upper-bound)]
    (available-targets random-target-value)))

(defn accumulate-targets
  [targets part]
  (let
    [target-values (map #(+ (:max targets) %) (range (:size part)))
     new-targets (map #(hash-map % part :max (+ 1 %)) target-values)]
    (reduce merge targets new-targets)))

(defn body-targets
  "Expects a seq of maps that have a :name and :size"
  [body-parts]
  (reduce accumulate-targets {:max 0} body-parts))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [left-part]
  (let
    [right-part (#(clojure.string/replace % #"^left-" "right-") (:name left-part))]
    (assoc left-part :name right-part)))

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce #(into %1 (set [%2 (matching-part %2)])) [] asym-body-parts))

(def sym-hobbit-body-parts (symmetrize-body-parts asym-hobbit-body-parts))
(def hobbit-body-targets (body-targets sym-hobbit-body-parts))

(defn -main
  "Hit a hobbit once or a specified number of times"
  ([]
    (let
      [hit-hobbit (hit hobbit-body-targets)
       body-part (clojure.string/replace (:name hit-hobbit) "-" " ")
       gloat (str "Hit you in the " body-part "!")]
      (println gloat)))
  ([count & args]
    (doseq [i (range (read-string count))] (-main))
    (println "I think you've had enough.")))
