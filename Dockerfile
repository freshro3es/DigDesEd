FROM openjdk:20
ADD /out/artifacts/DigDesEd_jar/DigDesEd.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]