FROM openjdk:17-ea-nanoserver
ADD /target/ServiceExpensesIncome1-0.0.1-SNAPSHOT.jar ServiceExpensesIncome1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ServiceExpensesIncome1-0.0.1-SNAPSHOT.jar"]
