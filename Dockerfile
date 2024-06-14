FROM openjdk:17-ea-nanoserver
ADD /target/serviceexpensesincome1-0.0.1-SNAPSHOT.jar serviceexpensesincome1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","serviceexpensesincome1-0.0.1-SNAPSHOT.jar"]
