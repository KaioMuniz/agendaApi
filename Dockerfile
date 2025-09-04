#Criando uma máquina virtual com JDK 21
FROM openjdk:21

#Criando uma pasta dentro do docker para guardar os arquivos do projeto
WORKDIR /app

#Copiando todos os arquivos do projeto para dentro desta pasta
COPY . /app

#Comando para fazer o DEPLOY (publicação do projeto)
RUN ./mvnw -B clean package -DskipTests

#Porta em que o projeto será executado
EXPOSE 8088

#Comando para rodar o projeto publicado
CMD ["java", "-jar", "target/projetoApiAgenda-0.0.1-SNAPSHOT.jar"]