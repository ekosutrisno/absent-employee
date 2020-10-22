FROM openjdk:11

EXPOSE 9000:9000

COPY /target/absensi-employee-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]