# auto-mendes

## Sobre

Sistema de registro de vendas entre vendedores e clientes.

## Modelo

MER

![MER](https://github.com/user-attachments/assets/3118aba3-06b1-4eba-9959-c660fc535585)

DER

![DER](https://github.com/user-attachments/assets/512fadd3-5711-4ac2-91c8-65456148f9f1)

Diagrama de classe

![diagrama-de-classe](https://github.com/user-attachments/assets/fa7f3c99-a826-47d0-883c-ae41acd962da)

# Recursos Do Projeto

## Auto Mendes Back End Spring Boot Java

- Hibernate.
- Validation.
- H2DB.
- PostGreeSQL.
- Lombok.
- Ulid.
- Swagger.
- SOLID.
- MVC.
- Spring Boot.
- Java 17.

# Requisitos Funcionais

## Funcionários

- Gerente deve registrar funcionário.
- Gerente deve listar funcionários.
- Gerente deve listar funcionários pelo cargo.
- Gerente deve listar funcionários pela matrícula.
- Gerente deve atualizar funcionário pelo id.

# Requisições

## Funcionários

### Registra Funcionário

```JSON
/api/employees/register-employee

{
  "name": "string",
  "cpf": "stringstringst",
  "email": "string",
  "telephone": "stringstri",
  "salary": 0,
  "matriculation": "7493388704",
  "commission": 0,
  "employeeType": "MANAGER"
}
```

### Listar funcionários

```JSON
/api/employees/list-employees?page=0&size=10
```

### Listar funcionários pelo cargo

```JSON
/api/employees/list-employees-by-position?page=0&size=10&employeeType=DEPUTY_MANAGER
```

### Listar funcionários pela matrícula

```JSON
/api/employees/list-employees-by-matriculation?page=0&size=10&matriculation=1 
```

### Atualizar funcionário pelo id

```JSON
/api/employees/update-employee-by-id?id=1

{
  "name": "string",
  "cpf": "stringstringst",
  "email": "string",
  "telephone": "stringstri",
  "salary": 0,
  "matriculation": "7493388704",
  "commission": 0,
  "employeeType": "MANAGER"
}
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


