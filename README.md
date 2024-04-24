<div align="center"> 
 
 # SDAtividade2

### Alunos
Ana Carolina Armentano e Silva<br>
Maria Eduarda<br>
João Fábio 

Executar o seguinte comando dentro da pasta de cada app: 

```
mvn spring-boot:run
```

# dns-server-app
```
http://localhost:8081/health
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

POST 
```
http://localhost:8181/perfil/
```
FromBody
```
{
  email : "some@email.com"
}
```

<img src="https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/bbc27a81-677e-448b-b7e7-6ff710858114"></img>


# validacao-app

GET
```
http://localhost:8182/health
```

POST 
```
http://localhost:8182/validacao
```
FromBody
```
{
  email : "some@email.com"
}
```

<img src="https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/a6986a62-c59f-4e17-bd02-6d7bc60ea6b9"></img>

</div>
