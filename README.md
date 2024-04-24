# SDAtividade2

Executar o seguinte comando dentro da pasta de cada app: 

```
mvn spring-boot:run
```

# dns-server-app
```
localhost:8081/health
```

# eureka-server-app

## dashboard 

```
http://localhost:8761
```

?? probleminha aqui default zone (registered replica)
tá dando unavailable

```
 http://localhost:8761/eureka/
```

## endpoints

GET
```
http://localhost:8761/health
```

?? probleminha aqui GET
```
http://localhost:8761/listApplications
```

# isp-server-app

GET
```
http://localhost:8080/health
```

# perfil-app

GET 
```
http://localhost:8181/health
```

?? probleminha aqui type=Method Not Allowed, status=405
GET 
```
http://localhost:8181/perfil
```

# validacao-app

GET
```
http://localhost:8182/health
```

?? probleminha aqui type=Method Not Allowed, status=405
POST 
```
http://localhost:8182/validacao
```
