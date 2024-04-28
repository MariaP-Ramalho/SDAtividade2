<div align="center">

 # Sistemas Distribuídos com Eureka, DNS e ISP servers 
 ### Recuperação e validação de perfis de usuário

<br>![Diagram](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/bb011d01-d703-4110-91c2-93bf90f3f621)
<!--Excalidraw: https://excalidraw.com/#json=9Dvb07mGXfhT5CZpdBmfs,jOlULBawkJB7Sm9nGcRFAQ-->

Este é um projeto que contém vários aplicativos para demonstrar conceitos de desenvolvimento de <br>sistemas distribuídos utilizando Eureka Server, Spring Boot, Maven, DNS, ISP e API Rest.

--- 

# Como Executar 🧰

Para cada aplicativo, acesse o diretório do projeto e, em seguida, inicie a execução <br>de uma aplicação dentro desse projeto, usando o Maven e o Spring Boot. Por exemplo: 

```bash
cd sd-trabalho-2
cd dns-server-app
mvn spring-boot:run
```

---

# Servidor ISP: `isp-server-app` 🌐

O `isp-server-app` é um componente crucial no ecossistema de sistemas distribuídos.<br>
Ele atua como um intermediário inteligente, recebendo requisições dos usuários e<br>
direcionando-as para as rotas apropriadas. Isso é fundamental em arquiteturas distribuídas,<br>
onde várias aplicações estão envolvidas e precisam se comunicar de forma eficiente.

## **Rota de Perfil** (POST)

Ao acessar esta rota, o `isp-server-app` efetua a requisição para o microsserviço da <br>
aplicação de perfil (`perfil-app`) e retorna o resultado para o usuário.

```
http://localhost:8080/perfil
```
```json
{ "email" : "some@email.com" }
```

![endpoint-perfil-no-isp](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/44a82f41-076a-4e4b-8924-e75d6e706675)<br>
![log de redirect para app perfil no isp](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/9fbcbcea-d5b2-450b-818a-42849ac21e4e)

## **Rota de Validação** (POST)

Semelhante à rota de perfil, esta rota efetua a requisição para o microsserviço da <br>
aplicação de validação (`validacao-app`) e retorna o resultado para o usuário.

```
http://localhost:8080/validacao
```
```json
{ "email" : "some@email.com" }
```

![endpoint-validacao-no-isp](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/f190dab4-456f-4f67-b1ad-cbcba5fb39da)<br>
![log de redirect para app validacao no isp](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/d8a07866-04f2-4fe6-909a-73b222b0f03e)

--- 

# Servidor DNS: `dns-server-app` 🔍

Fornece informações sobre as aplicações registradas no sistema, retornando um JSON <br>
contendo detalhes sobre todas as aplicações ativas, incluindo seus nomes, instâncias, endereços IP,<br>
status, URLs de verificação de saúde e outros metadados relevantes. 

Essas informações são essenciais para o servidor ISP (`isp-server-app`) realizar o roteamento adequado<br>
das requisições dos usuários para as aplicações correspondentes, que utiliza essas informações para encaminhar<br>
solicitações para as instâncias corretas de uma determinada aplicação com base em sua disponibilidade e status de saúde. 

## **Rota de Informações das Aplicações** (GET)
```
http://localhost:8081/getRegisteredApplications
```

---

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

---

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

---

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

---

# Contributors 💻

Ana Carolina Armentano e Silva ([@armentanoc](https://github.com/armentanoc))

Maria Eduarda Pamponet Ramalho ([@MariaP-Ramalho](https://github.com/MariaP-Ramalho))

João Fábio Argôlo de Almeida Júnior ([@Ninoar3](https://github.com/Ninoar3))

</div>
