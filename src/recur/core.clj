(ns recur.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.cors :refer [wrap-cors]]))

(defroutes api-routes
  (GET "/api/ping" [] {:status 200 :body {:msg (rand-int 100)}})

  (POST "/api/echo" req
    (println "we received:" req)
    {:status 200 :body {:you-sent (:body req)}})

  (route/not-found {:status 404 :body {:error "not found"}}))

(def app
  (-> api-routes
      (wrap-json-body {:keywords? true})
      (wrap-json-response)
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-methods [:get :post :put :delete :options])))

(defn -main []
  (run-jetty app {:port 3000 :join? false}))
