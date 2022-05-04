# Vertx Rest Api

This repository is an example of implementing reactive rest api using Eclipse Vert.x

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 8 or higher
* PostgreSQL 9

### Installing

* Clone repo
* Import the project in any IDE

### Build and Start the project

* Instace of PostgreSQL is up and running, update the application properties file ( to run docker container use the following command : docker run --detach --name vertxpostgres -e POSTGRES_PASSWORD=postgres --publish 5432:5432 -d postgres:9, then go inside the container and create the database)
* Run the main class if you are using IDE
* Package the application with maven ( mvn clean package ) and then start the jar ( java -jar "NAME_OF_JAR")

## Built With

* [Vert.x](https://vertx.io/)
* [Maven](https://maven.apache.org/) - Dependency Management


