FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=build/libs/json-storage-service-1.0.0.jar
COPY ${JAR_FILE} abc.jar
ENTRYPOINT ["java","-jar","/abc.jar"]