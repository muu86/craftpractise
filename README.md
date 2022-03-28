### craftpractise 웹 애플리케이션
springboot, mysql, jpa, docker, aws fargate

### 시작세팅
`application-dockertest.properties`
```properties
spring.datasource.url=jdbc:mysql://mysql-for-craftpractise:3306/craftpractise
spring.datasource.username=root
spring.datasource.password=1234

server.port=8081
```
스프링부트와 mysql 모두 도커 컨테이너에 올릴 경우 테스트 위해  
도커 네트워크 craftpractise-mysql 이름으로 만들고 연결 확인.  
스프링부트 로컬과 도커 컨테이너 두 경우 모두 연결 성공.  

```shell
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
# 프로파일 설정
docker run -p 8081:8081 --network craftpractise-mysql \
-e spring_profiles_active=dockertest \
--name craftpractise craftpractise:docker-test
```