# Demo RestDoc to Swagger UI Integrator

Simple Example.

# 준비: Docker Compose

- <a href="https://www.docker.com/products/docker-desktop/" target="_blank">도커 데스크톱 설치</a>
- 도커 컴포즈 실행. 8000 포트가 비어 있어야 함(8000:8080).
  - 각 서비스 루트에서 실행(`docker-compose.yml` 파일이 있는 곳).

```shell
docker-compose up -d --build
```

## 전제 조건

- Syntax Level: Java 17

# 전체 구성도 예시

![전체 구성도](./assets/images/Swagger_UI_Integrator.png)

# 문서 생성(테스트 수행)

테스트 코드를 실행하면 Rest Docs와 Ascii Doctor에 의해 .adoc 문서가 생성됩니다.

openapi3 태스크가 이를 Open API3 양식을 따르는 JSON으로 변환합니다.

# 문서 접근

접근: [도커 컨테이너 실행된 상태로 http://localhost:8000 접속](http://localhost:8000/)

## 참고

- Output Directory: `src/main/resources/static/docs`
- JSON 접근(Swagger UI가 수행): `http://localhost:8080/docs/openapi3.sample-service.json`
- Swagger UI 접근: `http://localhost:8000/`
