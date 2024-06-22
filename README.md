<div align="center">

 # Sistemas Distribuídos com Eureka, DNS e ISP servers 

Este projeto abrange uma variedade de aplicativos que servem como exemplos práticos para explorar e compreender 
os fundamentos do desenvolvimento de sistemas distribuídos. Através da utilização de tecnologias-chave como Eureka Server,
Spring Boot e Maven, o projeto visa demonstrar como criar, implantar e gerenciar aplicações distribuídas de forma eficiente. 

Além disso, a integração de componentes como DNS (Domain Name System), ISP (Intelligent Service Proxy) e API Rest enriquece
a experiência, permitindo a exploração de conceitos essenciais, como descoberta de serviços, gerenciamento distribuído de arquivos, roteamento inteligente de solicitações
e comunicação entre componentes distribuídos para validação e recuperação de perfis de usuário.

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

### Sucesso (`Created`)
![salvar-sucesso-ezgif com-video-to-gif-converter](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/4c65774a-aab1-4e8d-9cc8-f263244f3603)

### Erros
#### Nome inválido (HTTP `BadRequest`)
![salvar-badrequestnomeinvalido-ezgif com-video-to-gif-converter](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/96b9453f-e8ff-46fa-a69f-d2d848c0fbf9)

#### Arquivo vazio (HTTP `BadRequest`)
![salvar-badrequesttxtvazio-ezgif com-video-to-gif-converter](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/38279cf3-dc23-4488-a3f1-d0d7ec262264)

#### Tipo de arquivo inválido (HTTP `BadRequest`)
![salvar-badrequestpdf-ezgif com-video-to-gif-converter](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/9b95c089-646f-4420-a938-70f2e82f6107)

#### Já existe arquivo com mesmo nome (HTTP `Unprocessable Entity`)
![salvar-errounprocessableentity-ezgif com-video-to-gif-converter](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/55e8275f-6e33-4bdd-b40e-7231ac30e2ae)

## **Rota de Obter Arquivo** (POST)

Ao acessar esta rota, o `isp-server-app` efetua a requisição para o microsserviço da
aplicação de perfil (`perfil-app`), que acessa o microsserviço da aplicação mestre de gerenciamento de arquivos (`dfs-master-app`), que acessa aleatoriamente uma das aplicações nós (`dfs-a-app` e `dfs-b-app`) e recupera o arquivo a partir do nome enviado pelo usuário.

```
http://localhost:8080/perfil/obterArquivo
```

### Sucesso (HTTP `Ok`)
![obter - sucesso](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/d7a26e55-772a-497e-aad7-43d69d2fe28d)

### Erros

#### Erro não encontrado (HTTP `NotFound`)
![obter-arquivonotfound-ezgif com-video-to-gif-converter](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/12716fc2-8415-4ea7-93e0-3fa72b59d1e1)

### Erro nome inválido
![obter - nome invalido](https://github.com/MariaP-Ramalho/SDAtividade2/assets/88147887/96f2bb01-c25d-4d18-af2f-66b23af0f537)

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
