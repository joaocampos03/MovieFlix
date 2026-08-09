# MovieFlix

API REST construída em Spring Boot para organizar um catálogo de filmes e os serviços de streaming onde eles estão disponíveis.

## Sobre o Projeto

A ideia do MovieFlix é centralizar as informações de onde assistir cada filme, permitindo consultar o catálogo por categoria e por serviço de streaming associado. Pontos de destaque do projeto:

- **Catalogação por categoria**, facilitando a busca de filmes por gênero
- **Relacionamento N:N** entre filmes e serviços de streaming
- **Autenticação stateless via JWT**, protegendo os endpoints da API
- **Documentação automática** dos endpoints via Swagger/OpenAPI

## Estrutura do Projeto

O código é organizado em camadas, separando responsabilidades de configuração, exposição HTTP, persistência e regra de negócio:

```
src/main/java/br/com/movieflix/
├── config/         # Configurações de Spring, Security e Swagger
├── controller/     # Interfaces e implementações dos controllers REST
├── entity/         # Entidades mapeadas via JPA
├── repository/     # Interfaces Spring Data JPA
├── service/        # Regras de negócio
├── exception/      # Exceções e tratamento de erros
└── mapper/         # Conversão entre entidades e DTOs
```

## Stack

### Aplicação
- **Java 17**
- **Spring Boot 4** (Web, Data JPA, Security, Validation)
- **java-jwt (Auth0)** para emissão e validação dos tokens
- **Lombok** para reduzir código repetitivo

### Persistência
- **PostgreSQL** como banco relacional
- **Flyway** controlando as versões do schema

### Build e Documentação
- **Maven** (com wrapper incluso no repositório)
- **springdoc-openapi**, gerando a documentação e a UI do Swagger

## O que a API faz

**Usuários**
Cadastro e login, com emissão de token JWT para autenticar as demais requisições.

**Categorias**
CRUD de categorias usadas para classificar os filmes.

**Serviços de streaming**
Cadastro dos provedores (Netflix, Prime Video, etc.) que podem ser vinculados a um filme.

**Filmes**
Cadastro, edição, remoção e consulta — inclusive filtrando por categoria — além de nota de avaliação e vínculo com categorias e streamings.

> Todas as rotas exigem autenticação, com exceção de registro/login e da documentação do Swagger.

## Rodando localmente

**Pré-requisitos:** Java 17+, PostgreSQL 15+ e Maven (ou apenas o wrapper `./mvnw`).

1. Clone o repositório:
```bash
git clone [url-do-repositorio]
```

1. Aponte a conexão com o banco em `src/main/resources/application.yaml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5431/movieflix
    username: postgres
    password: postgres
```

1. Compile:
```bash
./mvnw clean package
```

1. Suba a aplicação:
```bash
./mvnw spring-boot:run
```

Por padrão, a API sobe em `http://localhost:8080`.

## Documentação interativa

Com a aplicação rodando, o Swagger UI fica acessível em:
```
http://localhost:8080/swagger/index.html
```

E o JSON do contrato OpenAPI em:
```
http://localhost:8080/api/api-docs
```

### Endpoints

#### Autenticação
- POST `/movieflix/auth/register` - Registrar novo usuário
- POST `/movieflix/auth/login` - Login de usuário

#### Categorias
- POST `/movieflix/category` - Criar categoria
- GET `/movieflix/category` - Listar categorias
- GET `/movieflix/category/{id}` - Buscar categoria por ID
- DELETE `/movieflix/category/{id}` - Deletar categoria

#### Serviços de Streaming
- POST `/movieflix/streaming` - Criar serviço de streaming
- GET `/movieflix/streaming` - Listar serviços de streaming
- GET `/movieflix/streaming/{id}` - Buscar serviço de streaming por ID
- DELETE `/movieflix/streaming/{id}` - Deletar serviço de streaming

#### Filmes
- POST `/movieflix/movie` - Criar filme
- GET `/movieflix/movie` - Listar filmes
- GET `/movieflix/movie/{id}` - Buscar filme por ID
- GET `/movieflix/movie/search?category={id}` - Buscar filmes por categoria
- PUT `/movieflix/movie/{id}` - Atualizar filme
- DELETE `/movieflix/movie/{id}` - Deletar filme

## Versionamento

Este projeto segue [SemVer](http://semver.org/). As versões publicadas ficam nas [tags do repositório](https://github.com/seu-usuario/movieflix/tags).

## Autor

**João Campos**
