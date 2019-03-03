#get base java jdk
FROM adoptopenjdk/openjdk11:jdk-11.0.2.9
RUN mkdir /opt/app
COPY target/backendAPI.jar /opt/app
EXPOSE 5001
CMD ["java", "-jar", "/opt/app/backendAPI.jar"]
