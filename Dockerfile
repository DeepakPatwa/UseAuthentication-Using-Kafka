FROM openjdk:11

ADD ./target/userlogin-0.0.1-SNAPSHOT.jar /event/src/userlogin-0.0.1-SNAPSHOT.jar
EXPOSE 8096
WORKDIR event/src
ENTRYPOINT ["java","-jar","userlogin-0.0.1-SNAPSHOT.jar"]
