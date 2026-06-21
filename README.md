# 💳 API de Pagamentos

API REST desenvolvida com Java 21 e Spring Boot para processamento de pagamentos, armazenamento de pedidos em Redis e envio automático de comprovantes por e-mail.

## 🚀 Tecnologias Utilizadas

* Java 21
* Spring Boot 4
* Spring MVC
* Redis
* Spring Mail
* Lombok
* Swagger / OpenAPI
* Maven

## 📌 Funcionalidades

* Captura de pagamentos via API REST
* Armazenamento de pedidos no Redis
* Envio automático de comprovante por e-mail
* Documentação interativa com Swagger
* Integração com aplicações frontend através de CORS

## 🏗️ Arquitetura

```text
src/main/java
│
├── controllers
│   └── PagamentosController
│
├── services
│   └── PedidoService
│
├── components
│   └── EmailComponent
│
├── dtos
│   ├── ClienteDTO
│   ├── ProdutoDTO
│   ├── ItemPedidoDTO
│   └── PedidoDTO
│
└── configurations
    ├── CorsConfiguration
    ├── RedisConfiguration
    └── SwaggerConfiguration
```

## 📖 Endpoint Principal

### Criar Pagamento

```http
POST /api/v1/pagamentos/criar
```

### Exemplo de Requisição

```json
{
  "id": "PED001",
  "cliente": {
    "id": "CLI001",
    "nome": "Maria Silva",
    "email": "maria@email.com"
  },
  "dataHora": "2026-06-21T10:30:00",
  "valor": 199.90,
  "itensPedido": [
    {
      "id": "1",
      "produto": {
        "id": "PROD001",
        "nome": "Notebook",
        "preco": 199.90
      },
      "quantidade": 1
    }
  ]
}
```

### Resposta de Sucesso

```text
Pagamento capturado com sucesso!
```

## 📧 Comprovante por E-mail

Após o processamento do pagamento, a aplicação envia automaticamente um e-mail HTML contendo:

* Dados do cliente
* Número do pedido
* Data da compra
* Valor total
* Lista de produtos
* Quantidade e subtotal de cada item

## 📦 Persistência

Os pedidos são armazenados no Redis utilizando a chave:

```text
pedido:{id}
```

Exemplo:

```text
pedido:PED001
```

## 📚 Documentação Swagger

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui/index.html
```

## ⚙️ Pré-requisitos

* Java 21+
* Maven
* Redis Server
* MailHog ou servidor SMTP configurado

## ▶️ Executando o Projeto

Clone o repositório:

```bash
git clone https://github.com/beatrizlima-tech/api-pagamentos.git
```

Acesse a pasta:

```bash
cd api-pagamentos
```

Execute:

```bash
mvn spring-boot:run
```

## 🎯 Objetivo do Projeto

Projeto desenvolvido para prática de desenvolvimento backend utilizando Spring Boot, Redis e integração de serviços de e-mail, simulando o fluxo de processamento de pagamentos em aplicações corporativas.

## 👩‍💻 Desenvolvedora

Beatriz Lima

GitHub:
https://github.com/beatrizlima-tech
