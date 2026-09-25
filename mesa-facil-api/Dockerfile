# Estágio de build: JDK 21 Alpine
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copia o conteúdo da pasta mesa-facil-api para /app
COPY . .

# Executa o build direto na raiz (/app)
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
RUN ./mvnw clean package -DskipTests

# Estágio de execução: JRE 21 Jammy
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia o JAR gerado
COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "./app.jar"]