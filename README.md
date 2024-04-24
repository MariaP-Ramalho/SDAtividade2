<div align="center"> 
 
# Sistemas Distribuídos - Atividade 2

### Alunos
Ana Carolina Armentano e Silva<br>
Maria Eduarda<br>
João Fábio 

Este é um projeto que contém vários aplicativos para demonstrar conceitos de desenvolvimento de sistemas distribuídos utilizando Eureka Server, Spring Boot, Maven, DNS, ISP e API Rest.

## Como Executar

Para cada aplicativo, execute o seguinte comando dentro da pasta do respectivo app:

```
mvn spring-boot:run
```

# `isp-server-app`

Servidor que recebe as requisições do usuário e encaminha para as rotas adequadas. 

```
http://localhost:8080/health
```

# `dns-server-app`

Obtem a lista de aplicações ativas e retornar para o servidor ISP

```
http://localhost:8081/health
```

# `eureka-server-app`

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

# `perfil-app`

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


# `validacao-app`

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
