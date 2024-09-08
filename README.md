### Backend API Adjustment

請在 `application.properties`修改成你數據庫的 url, username, 和 password

```sh
spring.datasource.url=jdbc:postgresql://localhost:xxxx/xxxx
spring.datasource.username=xxxx
spring.datasource.password=xxxx
```

請在`CorsConfig` 和 `SecurityConfig`，修改

```sh
http://localhost:5137
```

改成

```sh
http://localhost:xxxx
```

`xxxx`是正在運行的前端地址，如 `5137`, `3000`...
