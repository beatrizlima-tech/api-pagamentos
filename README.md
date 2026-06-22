# 💳 API de Pagamentos

API REST desenvolvida com Spring Boot para captura de pagamentos, armazenamento temporário de pedidos no Redis e envio automático de comprovantes por e-mail.

## 🚀 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Maven
* Redis
* Swagger / OpenAPI
* MailHog
* Lombok

---

## 📋 Funcionalidades

* Cadastro de pagamentos via API REST
* Armazenamento de pedidos no Redis
* Geração de comprovante de pagamento
* Envio automático de e-mail HTML
* Documentação automática com Swagger
* Configuração de CORS para integração com aplicações frontend

---

## 📂 Estrutura do Projeto

```text
src
├── components
│   └── EmailComponent
├── configurations
│   ├── CorsConfiguration
│   ├── RedisConfiguration
│   └── SwaggerConfiguration
├── controllers
│   └── PagamentosController
├── dtos
│   ├── ClienteDTO
│   ├── ProdutoDTO
│   ├── ItemPedidoDTO
│   └── PedidoDTO
└── services
    └── PedidoService
```

---

## 🔄 Fluxo da Aplicação

1. O cliente envia um pedido para a API.
2. O pagamento é processado.
3. Os dados do pedido são armazenados no Redis.
4. Um comprovante em HTML é gerado.
5. O comprovante é enviado por e-mail ao cliente.

---

## 📌 Endpoint Disponível

### Criar pagamento

```http
POST /api/v1/pagamentos/criar
```

### Exemplo de requisição

```json
{
  "id": "PED001",
  "cliente": {
    "id": "CLI001",
    "nome": "Maria Silva",
    "email": "maria@email.com"
  },
  "dataHora": "2025-06-20T15:30:00",
  "valor": 250.00,
  "itensPedido": [
    {
      "id": "ITEM001",
      "produto": {
        "id": "PROD001",
        "nome": "Notebook",
        "preco": 250.00
      },
      "quantidade": 1
    }
  ]
}
```

### Resposta

```text
Pagamento capturado com sucesso!
```

---

## 📧 Envio de E-mail

Após a captura do pagamento, a aplicação envia automaticamente um comprovante contendo:

* Dados do cliente
* Identificação do pedido
* Data da compra
* Valor total
* Lista de produtos
* Quantidade adquirida
* Subtotal de cada item

---

## 📖 Swagger

A documentação da API pode ser acessada após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui.html
```

---

## ⚙️ Pré-requisitos

* Java 21+
* Maven
* Redis
* MailHog

---

## ▶️ Executando o Projeto

```bash
mvn clean install
mvn spring-boot:run
```

---

## 👩‍💻 Autora

Beatriz Lima

Desenvolvedora Java Full Stack em formação, com foco em desenvolvimento backend utilizando Java, Spring Boot, APIs REST e bancos de dados.
