<div align="center">

# Sistemas Distribuídos com Eureka, DNS e ISP servers 

Este projeto abrange uma variedade de aplicativos que servem como exemplos práticos para explorar e compreender 
os fundamentos do desenvolvimento de sistemas distribuídos. Através da utilização de tecnologias-chave como Eureka Server,
Spring Boot e Maven, o projeto visa demonstrar como criar, implantar e gerenciar aplicações distribuídas de forma eficiente. 

Além disso, a integração de componentes como DNS (Domain Name System), ISP (Intelligent Service Proxy) e API Rest enriquece
a experiência, permitindo a exploração de conceitos essenciais, como descoberta de serviços, gerenciamento distribuído de arquivos, roteamento inteligente de solicitações
e comunicação entre componentes distribuídos para validação e recuperação de perfis de usuário e arquivos, tudo isso através da orquestração de containers com Docker.

<br>![image](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/003ee498-a867-4f16-85f3-4adedf669b85)
<!--Excalidraw: https://excalidraw.com/#json=Rr-a-rnaVy8Mh2fdP7_Fw,7YpgBqaOqjFu3wSP_Sd_Kg-->


--- 

# Como Executar 🧰

Dentro de cada projeto, você deve compilar utilizando o comando:

```bash
mvn clean package
```

Com o Rancher ou Docker Desktop abertos, abra o terminal na pasta raiz e execute:

```bash
docker-compose up --build
```

---

# Servidor ISP: `isp-server-app` 🌐

O `isp-server-app` é um componente crucial no ecossistema de sistemas distribuídos.<br>
Ele atua como um intermediário inteligente, recebendo requisições dos usuários e<br>
direcionando-as para as rotas apropriadas. Isso é fundamental em arquiteturas distribuídas,<br>
onde várias aplicações estão envolvidas e precisam se comunicar de forma eficiente.

## **Rota de Salvar Arquivo** (POST)

Ao acessar esta rota, o `isp-server-app` efetua a requisição para o microsserviço da
aplicação de perfil (`perfil-app`), que acessa o microsserviço da aplicação mestre de gerenciamento de arquivos (`dfs-master-app`), que acessa aleatoriamente uma das aplicações nós (`dfs-a-app` e `dfs-b-app`) e salva o arquivo enviado pelo usuário.

```
http://localhost:8080/perfil/salvarArquivo
```

### Sucesso (HTTP `Created`)
![salvar-sucesso](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/5dbbf290-eb6e-42dc-a8a9-406cd941a908)

### Erros
#### Nome inválido (HTTP `BadRequest`)
![salvar-bad-request-nome-invalido](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/67049b4e-4c5c-4495-8b9f-46d792a5814d)

#### Arquivo vazio (HTTP `BadRequest`)
![salvar-bad-request-txt-vazio](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/6df1a97e-a613-4ea8-ab1f-40a9096ffb88)

#### Tipo de arquivo inválido (HTTP `BadRequest`)
![salvar-bad-request-pdf](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/69564531-ccfc-46b0-bd97-ba4043be8723)

#### Já existe arquivo com mesmo nome (HTTP `Unprocessable Entity`)
![salvar-erro-unprocessable-entity](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/3ca0796e-f1db-47f3-bc45-17ded5ee4a87)

## **Rota de Obter Arquivo** (POST)

Ao acessar esta rota, o `isp-server-app` efetua a requisição para o microsserviço da
aplicação de perfil (`perfil-app`), que acessa o microsserviço da aplicação mestre de gerenciamento de arquivos (`dfs-master-app`), que acessa aleatoriamente uma das aplicações nós (`dfs-a-app` e `dfs-b-app`) e recupera o arquivo a partir do nome enviado pelo usuário.

```
http://localhost:8080/perfil/obterArquivo
```

### Sucesso (HTTP `Ok`)
![obter-sucesso](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/8d889822-b1b7-4018-b5b6-db18cef06838)

### Erros

#### Erro arquivo não encontrado (HTTP `NotFound`)
![obter-arquivo-not-found](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/8f7b823a-b2f8-45c3-aab9-f152ff80a945)

### Erro nome inválido (HTTP `BadRequest`)
![obter-erro-nome-invalido](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/9ed32db6-246f-466c-94bb-fb508a2e716f)

## **Rota de Perfil** (POST)

Ao acessar esta rota, o `isp-server-app` efetua a requisição para o microsserviço da <br>
aplicação de perfil (`perfil-app`) e retorna o resultado para o usuário.

```
http://localhost:8080/perfil
```

<div align="left">
 
```json
{
"email" : "some@email.com"
}
```
</div>

![endpoint-perfil-no-isp](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/44a82f41-076a-4e4b-8924-e75d6e706675)<br>
![log de redirect para app perfil no isp](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/9fbcbcea-d5b2-450b-818a-42849ac21e4e)

## **Rota de Validação** (POST)

Semelhante à rota de perfil, esta rota efetua a requisição para o microsserviço da <br>
aplicação de validação (`validacao-app`) e retorna o resultado para o usuário.

```
http://localhost:8080/validacao
```

<div align="left">
 
```json
{
"email" : "some@email.com"
}
```
</div>

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

![dns-servidor-de-nomes](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/1154d2a7-33d2-4726-9a2b-cce1b7085159)

---

# Servidor Eureka: `eureka-server-app` 📊

O servidor Eureka (`eureka-server-app`) é responsável por hospedar e manter um registro dinâmico <br>
de todas as instâncias de serviços disponíveis em um ambiente distribuído. Funciona como um diretório <br>
centralizado onde as aplicações registram suas instâncias conforme são iniciadas e retiradas de serviço. 

O dashboard, acessível através do endpoint `http://localhost:8761`, fornece uma interface gráfica para <br>
visualizar o status das aplicações registradas, suas instâncias e estatísticas de tráfego. Isso permite monitorar<br>
o funcionamento do sistema e identificar problemas de forma eficiente, além de facilitar a descoberta de serviços por parte de outras aplicações. 

## **Dashboard** (GET)
```
http://localhost:8761
```

![eureka-dashboard](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/7044d04e-dd50-4b03-8455-a9d9b74db9bf)

---

# Identificação de perfis na base de dados: `perfil-app` 📝

O app fornece endpoints para verificar a saúde da aplicação e para processar solicitações de perfil de usuário.
Quando acessado via ISP Server usando um método POST e o endpoint `http://localhost:8080/perfil`, o perfil-app espera receber
um corpo de requisição contendo um email. 

Com base nesse email, a aplicação busca o perfil associado na base de dados. Se encontrar o perfil correspondente,
retorna uma resposta com o email e o perfil do usuário, com o código de status HTTP 200 (Ok). Caso contrário,
retorna uma resposta de erro indicando que o perfil não foi encontrado, junto com o código de status HTTP 404 (Not Found).

## **Saúde da aplicação** (GET)
```
http://localhost:8181/health
```
## **Rota de perfil** (POST)

```
http://localhost:8181/perfil
```

<div align="left">
 
```json
{
"email" : "some@email.com"
}
```
</div>

### **Retornos possíveis**

<div align="left">
 
```json
{
    "error": {
        "errorMessage": "Perfil não encontrado para o email: joana@ucsal.edu.br",
        "statusCode": 404
    }
}
```

```json
{
    "email": "carolina@ucsal.edu.br",
    "perfil": "Aluno"
}
```

```json
{
    "email": "jose@ucsal.edu.br",
    "perfil": "Funcionario"
}
```

```json
{
    "email": "everton@pro.ucsal.br",
    "perfil": "Professor"
}
```
</div>

---

# Verificação de e-mail na base de dados: `validacao-app` 🧾

Esse app oferece endpoints para verificar a saúde da aplicação e para validar a existência de um usuário na base de dados.
Ao acessar o endpoint `http://localhost:8080/validacao` via ISP Server usando o método POST, a aplicação espera receber um corpo
de requisição contendo um email. 

Com base nesse email, o validacao-app verifica se o usuário existe na base de dados. Se o usuário for encontrado, retorna
uma mensagem indicando que o email existe na base de dados, com o código de status HTTP 200 (Ok). Caso contrário,
retorna uma resposta de erro indicando que o usuário não foi encontrado, novamente com o código de status HTTP 404 (Not Found).

## **Saúde da aplicação** (GET)
```
http://localhost:8182/health
```
## **Rota de validação** (POST)

```
http://localhost:8182/validacao
```

<div align="left">
 
```json
{
"email" : "some@email.com"
}
```
</div>

### **Retornos possíveis**

<div align="left">
 
```json
{
    "error": {
        "errorMessage": "Usuário não encontrado para o email: joaquim@ucsal.edu.br",
        "statusCode": 404
    }
}
```

```json
{
    "message": "E-mail do usuário maria@ucsal.edu.br existe na base de dados."
}

```
</div>

---

# Contributors 💻

Ana Carolina Armentano e Silva ([@armentanoc](https://github.com/armentanoc))

Maria Eduarda Pamponet Ramalho ([@MariaP-Ramalho](https://github.com/MariaP-Ramalho))

João Fábio Argôlo de Almeida Júnior ([@Ninoar3](https://github.com/Ninoar3))

</div>
