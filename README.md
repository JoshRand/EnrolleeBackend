# EnrolleeBackend

EnrolleeBackend is a Java and Spring Boot based web application backend.  Its purpose is to provide simple API request routes for the use of manipulating data in a MongoDB database.

## API Documentation & Usage
[POSTMAN DOCUMENTATION](https://documenter.getpostman.com/view/12598764/TVRoZ6xj)
## Installation

To use this application you'll need Java 14 or higher, Eclipse, and a MongoDB server. 
Once installed and imported into your workplace you'll need to edit the application.properties file in order to connect to the database of your liking. Replace \<AdminName\>, \<Password\>, \<DatabaseAddress\> with your desired external MongoDB database information, or you can comment out the MongoDB Atlas Database conneciton properties and use your local MongoDB database.

```bash
EX 1.
# MongoDB Atlas Database conneciton properties
#########################################################
spring.data.mongodb.uri=mongodb+srv://<AdminName>:<Password>@<serverAddress>?retryWrites=true&w=majority
spring.data.mongodb.database=<DatabaseName>
#########################################################
# MongoDB Local database connection properties
#########################################################
#spring.data.mongodb.database=codechallenge
#spring.data.mongodb.port=27017
#spring.data.mongodb.host=localhost
#########################################################
EX 2.
# MongoDB Atlas Database conneciton properties
#########################################################
#spring.data.mongodb.uri=mongodb+srv://<AdminName>:<Password>@<serverAddress>?retryWrites=true&w=majority
#spring.data.mongodb.database=<DatabaseName>
#########################################################
# MongoDB Local database connection properties
#########################################################
spring.data.mongodb.database=codechallenge
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
#########################################################

```
