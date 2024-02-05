# Usa una imagen de OpenJDK para Java 11 como base
FROM amazoncorretto:17

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el JAR de la carpeta de compilación a la imagen
COPY build/libs/creditmanagement-0.0.1-SNAPSHOT.jar app.jar


# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
