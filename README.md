# auto-mendes-back-end

API Spring Boot java da auto mendes

# Modelo

![diagrama-de-classe drawio](https://github.com/user-attachments/assets/a450c9cb-969e-4237-b23b-9f60ebcebe6e)


# Tecnologias 

- Hibernate/JPA
- Validation
- H2 DataBase
- PostGree DataBase
- Lombok
- Ulid
- Sweeger
- Cashining
- SOLID
- Arquitetura MVC

# Regra De Negócios

- Um cliente realiza mais de uma venda e uma venda é realizada por um cliente.
- Um funcionário realiza mais de uma venda e uma venda é realizada por um funcionário.
- Uma venda possui mais um carro e um carro é possuído por mais de uma venda.
- Dentro da concessionária existem tipos de funcionário como vendedor, gerente e subgerente.
- Um carro possui um modelo e um modelo é possuído por mais de um carro.
- Um modelo possui uma marca e uma marca é possuída por mais de um modelo.
- Somente os vendedores podem realizar vendas.
- Os dados do cliente são id, nome, cpf, rg, contato e data de nascimento.
- Os dados do carro são id, cor, valor, ano e placa.
- Os dados do funcionário são id, nome, tipo do funcionário, data de nascimento, cpf, email e rg.
- Os dados do modelo são id e nome.
- Os dados do marca são id e nome.
- Os dados da venda são id, data e hora e total.

# Requisitos Funcinais

## Funcionários 

- Gerente deve cadastra vendedor. 
- Gerente deve atualizar vendedor.
- Sistema deve listar todos funcionários que contenha mesmo nome.
- Gerente deve procurar funcionário pelo cpf. 

# Requisitos Não Funcionais

- Banco de dados para produção deve ser PostGree SQL.
- CPF tem que ser só número.
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
PATCH
/api/employees/update-employee?cpf=value

{
  "name": "string",
  "employeeType": "string",
  "birthDate": "string",
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


