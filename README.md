# Sistema de Gerenciamento de Filmes

Uma aplicação web para gerenciamento de filmes construída com Spring Boot e Thymeleaf.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Latest-green)
![H2 Database](https://img.shields.io/badge/H2-Database-blue)

## 📋 Descrição

Este projeto é uma aplicação web para gerenciamento de um catálogo de filmes. Permite aos usuários criar, visualizar, atualizar e excluir informações sobre filmes, como título, ano de lançamento, diretor e gênero.

A aplicação fornece tanto uma interface web amigável utilizando Thymeleaf quanto uma API RESTful para integração com outros sistemas.

## 🚀 Funcionalidades

- 📝 Cadastro completo de filmes (CRUD)
- 🔍 Busca e listagem de filmes
- 🌐 Interface web responsiva com Bootstrap
- 🔄 API REST completa para integração
- 📊 Banco de dados em memória (H2)

## ⚙️ Tecnologias Utilizadas

- **Back-end**: Java 21, Spring Boot 3.5.0
- **Persistência**: JPA / Hibernate, H2 Database
- **Front-end**: Thymeleaf, Bootstrap 5
- **Documentação da API**: SpringDoc OpenAPI (Swagger)
- **Mapeamento de Objetos**: MapStruct
- **Outras bibliotecas**: Lombok, Spring Validation

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

- **Controller**: Classes responsáveis por receber as requisições HTTP e delegar para a camada de serviço
- **Service**: Implementa a lógica de negócio da aplicação
- **Repository**: Interface de acesso ao banco de dados
- **Model**: Entidades JPA que representam os objetos de negócio
- **DTOs**: Objetos de transferência de dados
- **Mapper**: Conversão entre entidades e DTOs

## 📦 Estrutura do Projeto

```
src/
  ├── main/
  │   ├── java/pedroleonez/movies_thymeleaf/
  │   │   ├── controller/        # Controladores Web e REST
  │   │   ├── dtos/              # DTOs para entrada e saída de dados
  │   │   ├── mapper/            # Mapeadores entre entidades e DTOs
  │   │   ├── model/             # Entidades JPA
  │   │   ├── repository/        # Repositórios de acesso aos dados
  │   │   └── service/           # Lógica de negócio
  │   └── resources/
  │       ├── static/            # Recursos estáticos (CSS, JS)
  │       └── templates/         # Templates Thymeleaf
  └── test/                      # Testes da aplicação
```

## 🛠️ Instalação e Execução

### Pré-requisitos

- JDK 21
- Maven

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/pedroleonez/movies-thymeleaf.git
   cd movies-thymeleaf
   ```

2. Compile e execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse a aplicação:
   - Interface Web: [http://localhost:8080/movies](http://localhost:8080/movies)
   - Console H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Configurações do Banco de Dados

- URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: ` ` (vazio)

## 🔄 Endpoints da API

### Movies API

| Método | URL                   | Descrição                      |
|--------|----------------------|--------------------------------|
| GET    | `/api/movies`        | Lista todos os filmes          |
| GET    | `/api/movies/{id}`   | Busca um filme por ID          |
| POST   | `/api/movies`        | Cria um novo filme             |
| PUT    | `/api/movies/{id}`   | Atualiza um filme existente    |
| DELETE | `/api/movies/{id}`   | Remove um filme                |

### Interface Web

| URL                   | Descrição                        |
|----------------------|----------------------------------|
| `/movies`            | Página inicial e listagem         |
| `/movies/create`     | Formulário para criar filme       |
| `/movies/edit/{id}`  | Formulário para editar filme      |

## 📊 Modelo de Dados

### Movie

- **id**: Long (identificador único)
- **title**: String (título do filme)
- **movieYear**: String (ano de lançamento)
- **director**: String (diretor)
- **genre**: String (gênero do filme)

## 🔧 Desenvolvimento

Este projeto utiliza:

- **MapStruct** para mapeamento entre entidades e DTOs
- **Lombok** para redução de código boilerplate
- **Spring Validation** para validação de dados
- **H2 Database** para banco de dados em memória durante desenvolvimento

## 📝 Licença

Este projeto está sob a licença [MIT](LICENSE).

## 👥 Autor

- Pedro Leonez

---

📌 Desenvolvido com ❤️ usando Spring Boot e Thymeleaf
