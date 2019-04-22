FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD biblioteca-api/target/sistema-lerlivros-api-0.0.1-SNAPSHOT.jar sistema-lerlivros-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","sistema-lerlivros-api-0.0.1-SNAPSHOT.jar"]
