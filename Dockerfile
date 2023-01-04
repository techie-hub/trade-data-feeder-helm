FROM openjdk:17

COPY /build/libs/trade-data-feeder-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080
EXPOSE 9080

ENTRYPOINT ["java","-jar","/app/trade-data-feeder-0.0.1-SNAPSHOT.jar"]
#USER '10001'

