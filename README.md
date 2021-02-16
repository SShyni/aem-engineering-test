# AEM Engineering Test

This project is implemented using AEM archetype and Docker

## Prerequisites
*Docker*

*AEM 6.5 JAR*

*AEM license*

##This project is layered out using 2 Docker containers

Code Container `aa-core`:

    Code is built and deployed from this docker container

AEM Container `publisher`:

    The Roman Numeral web service is hosted on this AEM docker container.


## How to build this repo
- Start the container stack -> `./start.sh`
- Stop the container stack -> `ctrl-c`

## Modules

###`adobe-assignment:` AEM multi module maven project

###`base-aem-image:` AEM docker baseline image project

NOTE- As part of this project the AEM baseline image is not hosted GitHub or Docker Hub for security reason but is created from the AEM binaries using Dockerfile.

**Please place AEM6.5 binary JAR(name it `aem-author-4502.jar`) and license file (name it `license.properties`) under `base-aem-image` directory

## End point URL - http://localhost:8080/romannumeral?query=10

### Debugging
Command to login to the docker after starting the containers

`docker exec -it <container name e.g. aa-core/publisher> /bin/bash` 

Command to see running containers

`docker ps`

```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                    PORTS                    NAMES
08e21337d78b        maven:3.6.1-jdk-8   "/usr/local/bin/mvn-…"   14 minutes ago      Up 14 minutes (healthy)                            aa-core
f53420c6dd16        publisher           "java -jar cq-quicks…"   31 minutes ago      Up 14 minutes             0.0.0.0:8080->8080/tcp   publisher
```

`aa-core` container constantly runs health check and check if the AEM service is up and running
Check the health check next to the container status above.

Log into the docker container using the above command to check the logs under path-
`/opt/aem/crx-quickstart/logs`


###Files modified-
``` adobe-assignment/core/src/main/java/com/adobe/assignment/aem/core/number/impl/NumberException.java
adobe-assignment/core/src/main/java/com/adobe/assignment/aem/core/number/servlet/RomanNumeralServlet.java
adobe-assignment/core/src/main/java/com/adobe/assignment/aem/core/number/util/NumberConversion.java
adobe-assignment/core/src/main/java/com/adobe/assignment/aem/core/Constants.java

Test
adobe-assignment/core/src/test/java/com/adobe/assignment/aem/core/number/util/NumberConversionTest.java

Docker-
base-aem-image/Dockerfile
base-aem-image/publisher/Dockerfile
docker-compose.yml
start.sh 




