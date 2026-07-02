# Biblioteca Microservices

## Descrição da Arquitetura

Utilizando arquitetura de microsserviços com Spring Boot. A aplicação é composta por três serviços independentes e um servidor Nginx responsável pelo acesso ao sistema.

### Componentes

- **front-service**
    - Responsável pela interface web utilizando Spring Boot e Thymeleaf.
    - Consome os microsserviços através do RestClient.

- **autor-service**
    - Responsável pelo gerenciamento dos autores.
    - Realiza operações de cadastro, consulta, atualização e exclusão.

- **livro-service**
    - Responsável pelo gerenciamento dos livros.
    - Realiza operações de cadastro, consulta, atualização, exclusão e filtro por disponibilidade.
    - Comunica-se com o autor-service para validar a existência de autores.

- **PostgreSQL**
    - Cada microsserviço possui seu próprio banco de dados.

- **Nginx**
    - Atua como proxy reverso, direcionando as requisições do navegador para o front-service.

### Arquitetura

```
                                            Navegador
                                                 │
                                                 ▼
                                              Nginx
                                                 │
                                                 ▼
                                          Front-Service
                                           │          │
                                           ▼          ▼
                                   Autor-Service   Livro-Service
                                           │          │
                                           ▼          ▼
                                      PostgreSQL  PostgreSQL
```

---

## Instruções de Execução

### Pré-requisitos

- Docker Desktop
- Docker Compose

### Executando a aplicação

1. Clone o repositório.

2. Acesse a pasta do projeto.

3. Execute o comando:

```bash
docker compose up --build
```

4. Aguarde a criação dos containers.

5. Acesse a aplicação pelo navegador:

```
http://localhost
```

Caso o Nginx esteja configurado utilizando outra porta:

```
http://localhost:8088
```

### Containers criados

- postgres-autor
- postgres-livro
- autor-service
- livro-service
- front-service
- nginx

### Encerrando a aplicação

```bash
docker compose down
```