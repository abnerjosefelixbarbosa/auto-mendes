# auto-mendes-back-end

API Spring Boot java da auto mendes

# Modelo

![conssecionaria-auto-mendes-class-diagram-entity drawio (1)](https://github.com/user-attachments/assets/853632ab-e0d2-454f-b0cb-78c18b34a9c2)

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
- Lombok

# Regra De Negócios

- Um cliente realiza mais de uma venda e uma venda é realizada por um cliente.
- Um vendedor realiza mais de uma venda e uma venda é realizada por um vendedor.
- Uma venda possui mais um carro e um carro é possuído por mais de uma venda.
- Dentro da concessionária existem tipos de funcionário como vendedor, gerente e subgerente.
- Um carro possui um modelo e um modelo é possuído por mais de um carro.
- Um modelo possui uma marca e uma marca é possuída por mais de um modelo.
- Os dados do cliente são nome, cpf, rg, contato e data de nascimento.
    - Nome, cpf, rg, contato e data de nascimento do cliente são obrigatórios.
    - Cpf, rg e contato do cliente são únicos.
- Os dados do carro são cor, valor, ano e placa.
    - Cor, valor e ano do carro são obrigatórios.
- Os dados do funcionário são nome, tipo do funcionário, data de nascimento, cpf, email e rg.
    - Nome, tipo do funcionário, data de nascimento, cpf, email e rg do funcionário são obrigatórios.
    - Cpf, email e rg do funcionário são únicos.
- Os dados do modelo são nome.
    - Nome do modelo é obrigatório.
    - Nome do modelo é único.
- Os dados do marca são nome.
    - Nome do marca é obrigatório.
    - Nome do marca é único.
- Os dados da venda são data e hora e total.
    - Data e hora e total são obrigatórios.

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


