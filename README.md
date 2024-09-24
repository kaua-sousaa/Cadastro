# Sistema de Login

## Descrição
Esta é uma aplicação de autenticação desenvolvida com Spring Boot e PostgreSQL, permitindo que usuários realizem login e registro de forma segura.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Web
- Lombok
- PostgreSQL
- Docker
- Docker Compose

## Dependências
- **Spring Boot Starter Data JPA**: Para persistência de dados.
- **Spring Boot Starter Web**: Para criação de APIs RESTful.
- **Spring Boot Starter Security**: Para autenticação e autorização.
- **PostgreSQL**: Banco de dados utilizado.
- **Lombok**: Para reduzir o código boilerplate.
- **ModelMapper**: Para conversão de DTOs.
- **Gson**: Para manipulação de JSON.

## Pré-requisitos
Antes de executar a aplicação, verifique se você possui as seguintes ferramentas instaladas:
- Docker
- Docker Compose


## Configuração e teste
Exemplo feito no powershell
1. Clone o repositório:
   ```bash
   git clone https://github.com/kaua-sousaa/Cadastro.git
   cd nome_do_projeto
   New-Item .env -ItemType File (Criando arquivo .env)
   notepad .env (editando .env, copie e cole as variáveis de ambiente das instruções abaixo e salve)
   mvn clean package -DskipTests 
   docker-compose up --build
    ```
## Configuração do Ambiente

Para executar a aplicação, você precisará criar um arquivo `.env` na raiz do projeto com as seguintes variáveis de ambiente:

```plaintext
POSTGRES_USER=postgres
POSTGRES_PASSWORD=root
POSTGRES_DB=login-registro
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/login-registro
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=root
```

## Testando a aplicação
1. Abra o Postman
2. Coloque a requisição com POST
3. Coloque as seguintes URLs de registro e login:
    - localhost:8080/auth/registrar
    - localhost:8080/auth/login

Exemplo de Json para registro:
```json
{
  "nome": "João Silva",
  "email": "joao.silvaaaa@email.com",
  "cpf": "123.456.719-00",
  "telefone": "(11) 98765-4321",
  "senha": "senhaSegura123",
  "dataNascimento": "1990-05-20",
  "sexo": "Masculino",
  "idioma": "Português",
  "dataCriacao": "2024-09-15T14:12:24.721Z",
  "endereco": {
    "cep": "12345-678",
    "logradouro": "aaaa",
    "complemento": "Apto 202",
    "bairro": "Centro",
    "localidade": "São Paulo",
    "uf": "SP",
    "estado": "São Paulo",
    "pontoReferencia": "Próximo à praça central"
  }
}
```
Exemplo de Json para login:
```json
{
    "email":"joao.silvaaaa@email.com",
    "senha":"senhaSegura123"
}
```

