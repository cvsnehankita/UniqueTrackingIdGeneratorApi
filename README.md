Unique Tracking Number Generator API

Design and implementation of a REST-ful API that generates unique tracking numbers for parcels. This
API should be scalable, efficient, and capable of handling high concurrency.

Features
1. Generate unique tracking numbers on demand everytime
2. Store and retrieve tracking data from MongoDB
3. Easy REST endpoints for integration and Scalable and efficient architecture

Local Api
1. http://localhost:8080/country/add
2. http://localhost:8080/country/get/MY
3. https://uniquetrackingnumberapi-bafed499ccdb.herokuapp.com/next-tracking-number?origin_country_id=IN&destination_country_id=US&weight=56&created_at=&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=Neuron Network&customer_slug=neuron-network&created_by=TestUser

Heroku apis:
1. https://uniquetrackingnumberapi-bafed499ccdb.herokuapp.com/country/add
2. https://uniquetrackingnumberapi-bafed499ccdb.herokuapp.com/country/get/IN
3. http://localhost:8080/next-tracking-number?origin_country_id=IN&destination_country_id=US&weight=56&created_at=&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=Neuron Network&customer_slug=neuron-network&created_by=Test

Technologies used
1. Java SpringBoot (JDK 24 locally, JDK 17 for Heroku as it was the latest version supported for MongoDb on Heroku)
2. MongoDB (MongoDb compass locally and Third party Objectrocket with Heroku)
3. Apache Maven 3.9.9
4. Lombok 
5. JUnit and Mockito(for testing)

Prerequisites
1. Java SDK installed (17 and above)
2. Maven installed 
3. MongoDB instance running (local or cloud)
4. Git and GitHub installed (optional)

Setup
1. Create and init empty git repository or clone if the Repository already created
2. Create New Java project and configure the git repository
3. Configure MongoDB connection in application.properties
4. Build the project using Maven and run the application, mvn clean install
5. Add Entities, Service, Repository and Controller layers of the MVN architecture
6. Refer postman collection json for testing, TrackingNumberApi.postman_collection.json
6. Create and run unit test using mvn, mvn test

Contact: cvsnehankita@gmail.com