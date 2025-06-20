# Usa imagen oficial de Java 17 con un JDK slim (ligero)
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven dentro del contenedor
COPY target/memory-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (puerto por defecto de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]
