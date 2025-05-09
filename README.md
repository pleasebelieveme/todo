![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=250&section=header&text=TODO%20Project&fontSize=80)

## 🤔 개요
- 이 프로젝트는 스프링부트와 JPA를 사용해 회원 CRUD, 일정 CRUD, 회원 로그인 인증을 구현한 애플리케이션입니다.

##  🌳 개발환경
언어 : ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)

JDK : ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)

프레임워크 : ![Static Badge](https://img.shields.io/badge/SpringBoot-%23FFFF00?logo=springboot)

DB : ![Static Badge](https://img.shields.io/badge/MySql-%23FFFFFF?style=flat&logo=mysql)

ORM : ![Static Badge](https://img.shields.io/badge/JPA-FFA500?style=flat)



## 🔠 목차  

1. [📄 API 명세서](#-api-명세서)
2. [💿 ERD](#-erd)
3. [❓ 패키지 설명](#-패키지-설명)
4. [▶️ 실행방법](#️-실행방법)
5. [🛠 기능 요약](#-기능-요약)
6. [📂 디렉토리 구조](#-디렉토리-구조)



# 📄 API 명세서
<img width="897" alt="스크린샷 2025-04-05 오후 12 05 30" src="https://github.com/user-attachments/assets/9b5aeebc-bba2-4bff-84b3-c21c58291244" />


# 💿 ERD
<img width="660" alt="스크린샷 2025-04-05 오후 12 03 21" src="https://github.com/user-attachments/assets/740ecb4d-56b6-493a-aa6b-976117ca8351" />



# ❓ 패키지 설명
## 1. Entity(BaseEntity, Todo, Member)
- BaseEntity는 작성일, 수정일을 위한 클래스입니다.
- DB와 동일한 환경을 구성한 Entity 클래스입니다.

 ## 2. Dto
- Entity를 기반으로 실제 데이터가 이동될때 사용되는 클래스입니다.
- Request와 Response로 나눴습니다.
  
 ## 3. Controller
- 사용자에게 요청을 받고 결과값을 넘겨주는 역할을 하는 클래스입니다.
- 요청받은 데이터를 Service에 넘겨주고 데이터를 전달받습니다.
  
 ## 4. Service
- DB에 조회하기 전과 후에 비즈니스 로직을 작성하는 클래스입니다.
- 요청을 가공하여 Repository에 넘겨주고 전달받습니다.

 ## 5. Repository
- JPA의 기본기능을 사용하는 인터페이스입니다.

## 6. Filter, Config, Common
- URL요청과 로그인 기능을 검증하는 클래스입니다.

# ▶️ 실행방법

1. src.main.java.org.example.schedule.TodoApplication.java 파일을 열어 Spring Boot를 실행시킵니다.
2. start된 걸 확인한 후 Postman을 통해 검증합니다.

# 🛠 기능 요약

- 회원 CRUD, 일정 CRUD
- 회원 로그인 기능

# 📂 디렉토리 구조  
```java
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── example
    │   │           └── todov2
    │   │               ├── common
    │   │               └── domain
    │   │                   ├── comment
    │   │                   │   ├── controller
    │   │                   │   ├── dto
    │   │                   │   │   ├── request
    │   │                   │   │   └── response
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   ├── member
    │   │                   │   ├── controller
    │   │                   │   ├── dto
    │   │                   │   │   ├── request
    │   │                   │   │   └── response
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   ├── reply
    │   │                   │   ├── controller
    │   │                   │   ├── dto
    │   │                   │   │   ├── request
    │   │                   │   │   └── response
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   └── todo
    │   │                       ├── controller
    │   │                       ├── dto
    │   │                       │   ├── request
    │   │                       │   └── response
    │   │                       ├── entity
    │   │                       ├── repository
    │   │                       └── service
    │   └── resources
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── org
                └── example
                    └── todov2

```
