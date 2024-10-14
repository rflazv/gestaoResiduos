FROM openjdk:17-jdk-slim

# Defina o caminho do JAR diretamente
COPY out/artifacts/gestao_residuos_jar/gestao_residuos.jar app.jar

# Exponha a porta que sua aplicação utilizará
EXPOSE 8080

# Defina o comando de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
