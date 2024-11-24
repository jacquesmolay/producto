FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/producto.micro-0.0.1.jar
COPY ${JAR_FILE} app_producto.jar
EXPOSE 9004
ENTRYPOINT ["java","-jar","app_producto.jar"]