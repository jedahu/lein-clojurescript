(defproject hello "1.1.2"
  :description "helloworld clojurescript"
  :dev-dependencies [[lein-clojurescript "1.1.2"]]
  :extra-classpath-dirs ["src"]
  :cljs
  {:output-to "resources/public/js/hello.js"
   :output-dir "resources/public/js/out"
   :optimizations :advanced

   ;; `java.lang.System.out/print` is bound to `*print-fn*` in
   ;; `test/hello/test.cljs`.
   :externs ["externs.js"]

   ;; The `upcase` function from `text_util.js` is used in `src/hello.cljs`.
   :libs ["js-libs/text_util.js"]

   ;; The `randomInt` function from `random.js` is used in
   ;; `test/hello/test.cljs`.
   :foreign-libs [{:file "js-foreign/random.js"
                   :provides ["random"]}]

   ;; Note that in test/hello/test.cljs this function is exported, so it is
   ;; still callable with advanced optimizations.
   :test-cmd "hello.test.test_in_rhino()"})
