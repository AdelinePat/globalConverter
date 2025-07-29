# FROM openjdk:17-jdk-alpine
FROM openjdk:24-jdk

COPY out/ /globalConverter/out

COPY gson-2.10.1.jar /globalConverter/

CMD ["java", "-cp", "/globalConverter/gson-2.10.1.jar:/globalConverter/out/production/globalConverter", "main.Main"]