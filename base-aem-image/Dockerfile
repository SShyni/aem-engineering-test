FROM ubuntu

WORKDIR /opt/aem

COPY aem-author-4502.jar cq-quickstart.jar

COPY license.properties .

RUN apt-get update && \
    apt-get install -y curl && \
    apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \
    apt-get install -y openjdk-8-jdk

RUN java -jar cq-quickstart.jar -unpack
