## Card Microservice

## Author
- [Harrison Kungu](https://github.com/harrisonkungu) 


### Building and running the application

#### Ensure you have docker installed
#### I have specifically targeted Java version 17 as the default version for running this application. Incase you encounter some issues, kindly check your `java --version` for compliance
#### If you need to run the application directly on your terminal, ensure that you have postgres installed and port 5432 open.


#### Run below command to create a target snapshot 

The target snapshot will be called `loop-0.0.1-SNAPSHOT.jar` located in `target` folder

```
mvn clean package -DskipTests
```

#### Dockerizing the service

Ensure that docker is started and running before running the below command. This command is meant to create the images (postgres and the java service) required and start the container. All dependencies will be installed in this phase.

```
docker compose up -d --build
```

The app should be running on port http://localhost:9191. Incase this port is being used by some other local resources, you can always change it in docker-compose.yml file `ports` section. Do not forget to rebuild and run your application after making these changes. 



#### Testing the Cards service

Open postman/ThunderClient or any other Rest Api client to do the testing.
I have also included the swagger ui documentation, that lists all the implemented end points.


card-controller

PUT
/cards/update-card/{cardId}


POST
/cards/create-cards


POST
/cards/create-card


GET
/cards/ping-card


GET
/cards/getcard-by-id/{id}


GET
/cards/get-cards


DELETE
/cards/delete-card/{cardId}

account-controller


PUT
/account/update-account/{accountId}


POST
/account/create-accounts


POST
/account/create-account


GET
/account/ping-account


GET
/account/getaccount-by-id/{id}


GET
/account/get-accounts


DELETE
/account/delete-account/{accountId}

 
#### Documentation

Once you have started the app, visit - [Open Swagger Documentation](http://localhost:9191/cards-service/swagger-ui/index.html) to perform all the test required 


------Happy testing---------------
