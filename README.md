## This is a RESTful, Graphql and Microservice java + spring boot API.
### implementation details:
* the restful API with Spring boot data jpa and web starter kit, H2 in memory DB.
    * accessible at: http://localhost:8080/dogs, /dogs/name, /dogs/breed, /{id}/breed
* the graphql API with graphql java tools and graphiql spring boot.
    * schema accessible at: http://localhost:8080/graphql/schema.json , graphiql interface accessible at: http://localhost:8080/graphiql
* the microservice with netflix eureka registry and discovery service.
    * eureka server and client should be run simultaneously.
    * eureka server accessible at: http://localhost:8761/
    * microservice accessible at: http://localhost:8762/dogs

This is done as part of Udacity java web developer nanodegree.
