# API Spider
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Vitor221/spider-spring/blob/main/LICENSE)

# Sobre o projeto

API Spider é uma aplicação backend baseada no super-herói, foi desenvolvido como estudo baseado no curso Java Completo 2023 Programação Orientada a Objetos do Nélio Alves no site da Udemy, [Curso Java](https://www.udemy.com/course/java-curso-completo/).

A aplicação consiste no gerenciamento dos heróis, usuários e vilões. Podendo inserir, consultar, deletar ou atualizar os dados. O conceito foi inspirado no filme do aranhaverso, onde o usuário pode criar vários homens-aranhas que existe no multiverso ou vilões do herói.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- H2
- JPA / Hibernate
- Maven

# URLs
- /spiders: http://localhost:8080/spiders
- /users: http://localhost:8080/users
- /villains: http://localhost:8080/villains

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/Vitor221/spider-spring.git

# construir o projeto
$ ./mvn clean package

# executar o projeto
$ java -jar target/spider-0.0.1-SNAPSHOT.jar
```
A API poderá ser acessada em http://localhost:8080/.
Para acessar o banco de dados em memória da API: http://localhost:8080/h2-console.

## API Endpoints

- Criar Usuário
```bash
$ http POST :8080/users name="Vitor Eduardo" email="vitor@gmail.com" phone="11 9999999" password="1234"

[
  {
    "name": "Vitor Eduardo",
    "id": 1,
    "email": "vitor@gmail.com",
    "password": "1234",
    "phone": "11 999999"
  }
]
```
- Listar Usuários
```bash
$ http GET :8080/users

[
  {
    "name": "Vitor Eduardo",
    "id": 1,
    "email": "vitor@gmail.com",
    "password": "1234",
    "phone": "11 999999"
  }
]
```
- Atualizar Usuário
```bash
$ http PUT :8080/users/1 name="Vitor" email="eduardo@gmail.com" phone="11 9999999" password="1234"

[
  {
    "name": "Vitor",
    "id": 1,
    "email": "eduardo@gmail.com",
    "password": "1234",
    "phone": "11 999999"
  }
]
```
- Remover Usuário
```bash
$ http DELETE :8080/users/1

[]
```

# Autor

Vitor Eduardo Nascimento Orasio

https://www.linkedin.com/in/vitor-eduardo-52a295213/
