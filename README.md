# auto-mendes-back-end

API Spring Boot java da auto mendes

# Modelo

![diagrama-de-classe drawio](https://github.com/user-attachments/assets/6904d3b5-97ab-4826-830f-ac49331ac549)

# Back End Java

- Hibernate/JPA
- Validation
- H2 DataBase
- PostGree DataBase
- Lombok
- Ulid
- Sweeger
- Cashining

# Requisitos Funcinais

## Funcionários 

- Gerente deve cadastra vendedor 
- Gerente deve atualizar vendedor
- Sistema deve listar todos funcionários que contenha mesmo nome
- Gerente deve procurar funcionário pelo cpf 

# Requisitos Não Funcionais

- Banco de dados para produção deve ser PostGree SQL.
- CPF tem que ser só número
- O framework Spring Boot com linguagem Java deve ser utilizado. 

# Requisições

## Funcionários

### Registra Funcionário

```JSON
POST
/api/employees/register-employee

{
  "name": "string",
  "employeeType": "string",
  "birthDate": "string",
  "cpf": "string",
  "rg": "string",
  "email": "string",
  "contact": "string"
}
```

### Atualizar Funcionário 

```JSON
PUT
/api/employees/update-employee?cpf=value

{
  "name": "string",
  "employeeType": "string",
  "birthDate": "string",
  "cpf": "string",
  "rg": "string",
  "email": "string",
  "contact": "string"
}
```

### Procura Funcionário

```JSON
GET
/api/employees/search-employee?cpf=value
```

### Listar Funcionário Pelo Nome

```JSON
GET
/api/employees/list-employee-by-name?name=value?page=value?size=value?sort=value
```
# Execução Do Projeto

- Copie e execute repositório em uma IDE.
- Acesse [a docmentação da API](http://localhost:8080/swagger-ui/index.html) ou use outra plataforma para testa a API.

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/auto-mendes-back-end-java.git
```

# Autor

Abner José Felix Barbosa.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)


