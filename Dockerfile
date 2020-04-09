FROM maven:3.6.3-jdk-11-openj9

COPY ./src/main/resources/assets/config.yml config.yml
COPY ./target/TutorResourceServer-1.0.jar app.jar

ENTRYPOINT java -jar app.jar server config.yml