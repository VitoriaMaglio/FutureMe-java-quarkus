# FutureMe - Web API em Java com Quarkus

## Descrição

O **FutureMe** é um projeto em **Java** utilizando o framework **Quarkus**, com o objetivo de fornecer uma API REST para gerenciamento de usuários, rotinas e profissões. A aplicação foi desenvolvida para demonstrar boas práticas em desenvolvimento backend, incluindo persistência de dados, rotas REST e deploy em nuvem.

Principais funcionalidades:

* Cadastro de usuários.
* Consulta de rotinas.
* Gerenciamento de profissões.
* Estrutura pronta para integração com front-end.

---

## Tecnologias Utilizadas

* Java 17
* Quarkus
* Maven
* JPA / Hibernate
* Oracle 
* Docker
* Render (para deploy em nuvem)

---

## Pré-requisitos

Antes de rodar o projeto, você precisará de:

* Java 17 instalado.
* Maven instalado.
* Banco de dados configurado.
* Docker.

---

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/futureme.git
cd futureme
```

2. Configure o banco de dados no arquivo `application.properties`:

```properties
quarkus.datasource.db-kind=
quarkus.datasource.jdbc.url=
quarkus.datasource.username=seu_usuario
quarkus.datasource.password=sua_senha
```

3. Compile o projeto:

```bash
mvn clean package -DskipTests
```

4. Rode localmente:

```bash
mvn quarkus:dev
```

O servidor rodará por padrão em `http://localhost:8080`.

---



## Testes

A API pode ser testada usando **Postman** ou **Insomnia**. Certifique-se de enviar requisições para `http://localhost:8080`.

---



