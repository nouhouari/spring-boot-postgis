### Spring Boot and PostGIS tutorial

This project demonstrate how you can use PostGIS and Spring Boot to manage spatial data

#### Run PostGIS
```
docker-compose up -d
```

### Buid the applicaion
```
mvn clean install
```

### Run the application
```
mvn spring-boot:run
```


### Test the REST API

Open your browser at <http://localhost:8980/city/48.232509500000106/-101.29627319999997/200000>


- 1st parameter: latitude in degree
- 2nd parameter: longitude in degree
- 3rd parameter: distance in meter


This will return all the cities within the distance around the specified location.

