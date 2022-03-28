# 메이븐 buildpack 으로 스프링부트 docker 이미지 생성
./mvnw spring-boot:build-image \
-Dspring-boot.build-image.imageName=craftpractise:docker-test

# 스프링부트 컨테이너와 mysql 컨테이너가 통신할 네트워크 생성(로컬 테스트용)
docker network create craftpractise-mysql

# mysql(arm64)
docker run --name mysql-for-craftpractise \
-p 3307:3306 --network craftpractise-mysql -e MYSQL_ROOT_PASSWORD=1234 -d \
arm64v8/mysql:8-oracle

# craftpractise 스프링부트 도커 실행
docker run -p 8081:8081 --network craftpractise-mysql \
-e spring_profiles_active=dockertest \
--name craftpractise craftpractise:docker-test