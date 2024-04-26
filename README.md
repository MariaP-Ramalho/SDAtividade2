<div align="center"> 
 
# Sistemas Distribuídos - Atividade 2

### Alunos
Ana Carolina Armentano e Silva<br>
Maria Eduarda<br>
João Fábio 

![image](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/bb011d01-d703-4110-91c2-93bf90f3f621)
<!--Excalidraw: https://excalidraw.com/#json=9Dvb07mGXfhT5CZpdBmfs,jOlULBawkJB7Sm9nGcRFAQ-->
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
http://localhost:8081/getRegisteredApplications
```

# `eureka-server-app`

## dashboard 

```
http://localhost:8761
```

## endpoints

GET
```
http://localhost:8761/health
```

# `perfil-app`

GET 
```
http://localhost:8181/health
```

POST - ACESSADO VIA ISP SERVER
```
http://localhost:8080/perfil
```
FromBody
```
{
  email : "some@email.com"
}
```

<img src="https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/e825c329-92c2-43e9-9c17-b4a1e54fd8d4"></img>


# `validacao-app`

GET
```
http://localhost:8182/health
```

POST - ACESSADO VIA ISP SERVER
```
http://localhost:8080/validacao
```
FromBody
```
{
  email : "some@email.com"
}
```

<img src="https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/a6986a62-c59f-4e17-bd02-6d7bc60ea6b9"></img>

</div>
