cd ../../../
mvn clean package -DskipTests
cp target\ROOT.war src/main/docker
cd src/main/docker
docker-compose up -d 


### rebuild project
cd src/main/docker
docker-compose down
docker rmi weather-app-docker-spring-postgres:latest
