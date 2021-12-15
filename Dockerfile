FROM openjdk:8
EXPOSE 8080
ADD target/exchange-rate.jar exchange-rate.jar
ENTRYPOINT ["java","-jar","/exchange-rate.jar"]