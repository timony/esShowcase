How to start:

### Quick start
1. Run docker containers  
```cd ./docker && docker-compose up  will trigger:```  
  - axon-server: glue for Axon applications - event store and many more
  - price-opitimisation-es-postgres: projection database

2. Start application  
```./gradlew bootRun```  
Starts the application

3. Check application is running  
[http://localhost:8090/api/v1/datalaod](http://localhost:8090/api/v1/datalaod)  
should give
```json
{
    "@class": "java.util.LinkedHashMap",
    "timestamp": [
        "java.util.Date",
        1587119192767
    ],
    "status": 500,
    "error": "Internal Server Error",
    "message": "No message available",
    "path": "/api/v1/dataload"
}
```

### ENDPOINTS

#### GET Get all data laods
[http://localhost:8090/api/v1/datalaod](http://localhost:8090/api/v1/datalaod)  
#### GET Get one data load
[http://localhost:8090/api/v1/datalaod/{id}](http://localhost:8090/api/v1/datalaod/{id}) 
#### POST Upload data load 
[http://localhost:8090/api/v1/datalaod](http://localhost:8090/api/v1/datalaod/) 

