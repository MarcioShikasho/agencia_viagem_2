# Agência de Viagem - API REST

Este projeto é uma API RESTful desenvolvida com Spring Boot, que simula o backend de uma agência de viagens. 

## Funcionalidades

- Cadastro, listagem e busca de destinos turísticos
- Reserva de destinos por clientes
- Avaliação de destinos
- Exclusão e atualização de destinos
- Autenticação com Spring Security (usuário e admin)

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## Usuários Padrão

- **Admin**  
  - Login: `admin`  
  - Senha: `admin123`

- **Cliente**  
  - Login: `cliente`  
  - Senha: `user123`

## Como rodar

1. Configure seu banco de dados PostgreSQL no `application.properties`
2. Rode a aplicação com `mvn spring-boot:run`
3. Use ferramentas como Postman ou `curl` para testar os endpoints protegidos

## Endpoints principais

- `GET /destinos`
- `POST /destinos`
- `GET /destinos/{id}`
- `PATCH /destinos/{id}/avaliar`
- `POST /destinos/{id}/reservar`
- `GET /destinos/reservas`

---

> Projeto desenvolvido como desafio acadêmico na disciplina de Desenvolvimento de Software Web.
