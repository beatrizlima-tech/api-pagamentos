# 💳 API Pagamentos

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-green?style=for-the-badge\&logo=springboot)
![Redis](https://img.shields.io/badge/Redis-Database-DC382D?style=for-the-badge\&logo=redis)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-Messaging-FF6600?style=for-the-badge\&logo=rabbitmq)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge\&logo=swagger)
![License](https://img.shields.io/badge/license-MIT-lightgrey?style=for-the-badge)

---

# 📌 Sobre o projeto

A **API Pagamentos** é uma aplicação backend desenvolvida com **Java** e **Spring Boot** responsável pelo processamento de pagamentos em uma arquitetura baseada em microsserviços.

Após receber um pedido, a aplicação registra as informações no **Redis**, gera um comprovante em HTML e envia automaticamente um e-mail ao cliente, simulando o fluxo de confirmação de pagamento utilizado em sistemas reais.

Este projeto faz parte de um ecossistema composto pela **API Pedidos**, demonstrando integração entre serviços por meio de mensageria.

---

# 🚀 Funcionalidades

* Recebimento de pedidos via API REST
* Processamento de pagamentos
* Armazenamento temporário dos pedidos no Redis
* Geração automática de comprovante em HTML
* Envio de comprovante por e-mail
* Documentação da API com Swagger/OpenAPI
* Configuração de CORS para integração com aplicações frontend

---

# 🧱 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web MVC
* Redis
* RabbitMQ
* Spring Mail
* Swagger / OpenAPI
* Lombok
* Maven

---

# 🏗️ Estrutura do Projeto

```text
src/main/java/

├── components
│   └── EmailComponent
│
├── configurations
│   ├── CorsConfiguration
│   ├── RedisConfiguration
│   └── SwaggerConfiguration
│
├── controllers
│   └── PagamentosController
│
├── dtos
│   ├── ClienteDTO
│   ├── ProdutoDTO
│   ├── ItemPedidoDTO
│   └── PedidoDTO
│
└── services
    └── PedidoService
```

---

# 🔄 Fluxo da Aplicação

```text
API Pedidos
      │
      ▼
API Pagamentos
      │
      ▼
Redis
      │
      ▼
Geração do comprovante
      │
      ▼
Envio de e-mail
```

---

# 🔗 Endpoint

| Método | Endpoint                   | Descrição           |
| ------ | -------------------------- | ------------------- |
| POST   | `/api/v1/pagamentos/criar` | Processar pagamento |

---

# 📧 Recursos Implementados

Após o processamento do pagamento, a aplicação:

* Armazena os dados do pedido no Redis
* Gera automaticamente um comprovante em HTML
* Envia um e-mail contendo:

  * Dados do cliente
  * Número do pedido
  * Data da compra
  * Produtos adquiridos
  * Quantidade
  * Valor total

---

# ⚙️ Como Executar

## 1. Clone o repositório

```bash
git clone https://github.com/beatrizlima-tech/api-pagamentos.git
```

## 2. Inicie os serviços necessários

* Redis
* RabbitMQ
* MailHog

## 3. Execute a aplicação

```bash
mvn spring-boot:run
```

---

# 📖 Documentação

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui.html
```

---

# 📚 Conceitos Aplicados

* Programação Orientada a Objetos
* Microsserviços
* API REST
* Comunicação entre serviços
* RabbitMQ
* Redis
* Envio de e-mails
* Spring Mail
* Swagger/OpenAPI
* Arquitetura em Camadas

---

# 📌 Melhorias Futuras

* Persistência definitiva dos pagamentos em banco de dados
* Integração com gateway de pagamento
* Histórico de transações
* Tratamento global de exceções
* Testes automatizados
* Dockerização da aplicação

---

# 👩‍💻 Autora

Desenvolvido por **Beatriz Lima**

🔗 GitHub
https://github.com/beatrizlima-tech

💼 LinkedIn
https://www.linkedin.com/in/beatrizlima-tech
