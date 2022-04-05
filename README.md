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

### 폴더 구조
헥사고날 아키텍처 연습

- api 호출부 어댑터 (controller)
- 애플리케이션 코어 (도메인 모델, 비지니스 로직)
- 인프라스트럭쳐 어댑터 (데이터베이스 접속, 메일 서버 접속, 캐쉬 등)

#### 요청 흐름  
apiController -> Service -> Management(facade) -> repository  
#### Management(Facade 계층)
도메인(entity) 객체에 자연스럽게 어울리지 못 하는 모든 비지니스 로직을 캡슐화한다. (CRUD 연산 외의 로직)

```shell
./src
├── main
│   ├── java
│   │   └── com
│   │       └── mj
│   │           └── craftpractise
│   │               ├── CraftpractiseApplication.java
│   │               ├── config
│   │               │   └── SecurityConfiguration.java
│   │               ├── domain
│   │               │   ├── application
│   │               │   │   ├── GoodsService.java
│   │               │   │   ├── command
│   │               │   │   │   └── AddGoodsCommand.java
│   │               │   │   └── impl
│   │               │   │       └── DefaultGoodsService.java
│   │               │   ├── common
│   │               │   │   └── model
│   │               │   │       └── AbstractBaseEntity.java
│   │               │   └── model
│   │               │       ├── customer
│   │               │       │   ├── Cart.java
│   │               │       │   ├── Customer.java
│   │               │       │   └── Wishlist.java
│   │               │       ├── goods
│   │               │       │   ├── Goods.java
│   │               │       │   ├── GoodsComment.java
│   │               │       │   ├── GoodsCommentImage.java
│   │               │       │   ├── GoodsDt.java
│   │               │       │   ├── GoodsImage.java
│   │               │       │   ├── GoodsManagement.java
│   │               │       │   ├── GoodsPrice.java
│   │               │       │   ├── GoodsQuest.java
│   │               │       │   ├── GoodsQuestAnswer.java
│   │               │       │   └── Stock.java
│   │               │       └── order
│   │               │           ├── Order.java
│   │               │           ├── OrderDt.java
│   │               │           └── OrderStock.java
│   │               ├── infrastructure
│   │               │   └── repository
│   │               │       └── GoodsRepository.java
│   │               └── web
│   │                   ├── api
│   │                   │   └── admin
│   │                   │       └── GoodsApiController.java
│   │                   ├── page
│   │                   ├── payload
│   │                   │   ├── AbstractPayload.java
│   │                   │   ├── AddGoodPayload.java
│   │                   │   └── BaseParam.java
│   │                   └── result
│   │                       └── ApiResult.java
│   └── resources
│       ├── application-dockertest.properties
│       ├── application.yml
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── mj
                └── craftpractise
                    ├── CraftpractiseApplicationTests.java
                    └── domain
                        └── model
                            └── goods
                                └── GoodsTest.java
```

### 공부할 것
custom validation
- https://markoantic.medium.com/conditional-validation-in-java-applications-80a24f06d721