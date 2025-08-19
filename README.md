# Automendes 

## Sobre

Sistema da concessionária Auto Mendes.

## Modelo

```mermaid
classDiagram

Employee -- EmployeeType
Customer -- CustomerType
Vehicle -- BoxgearType
Vehicle -- VehicleType
SaleVehicle -- SaleVehicleId
SaleVehicle -- PaymentType

Employee "1" --* "*" Sale
Customer "1" --* "*" Sale
Sale "1" -- "*" SaleVehicle
Vehicle "1" -- "*" SaleVehicle
Model "1" --* "*" Vehicle
Brand "1" --* "*" Model

class Customer {
    <<entity>>
    - id: String
    - document: String
    - name: String
    - email: String
    - phone: String 
    - customerType: CustomerType
}

class Employee {
    <<entity>>
    - id: String
    - name: String
    - email: String
    - matriculation: String
    - phone: String
    - birthDate: LocalDate
    - commission: BigDecimal
    - employeeType: EmployeeType
}

class Sale {
    <<entity>>
    - id: String
    - quantity: Integer
    - SaleDateTime: LocalDateTime
    - total: BigDecimal
    - paymentType: PaymentType
    - customer: Customer
    - employee: Employee
}

class SaleVehicle {
    <<entity>>
    - saleVehicleId: SaleVehicleId
    - sale: Sale
    - vehicle: Vehicle
}

class SaleVehicleId {
    - saleId: String
    - vehicleId: String
}


class Vehicle {
    <<entity>>
    - id: String
    - plate: String
    - price: BigDecimal
    - model: Model
    - boxgearType: BoxgearType
    - vehicleType: VehicleType
}

class Model {
    <<entity>>
    - id: String
    - name: String
    - brand: Brand
}

class Brand {
    <<entity>>
    - id: String
    - name: String
}

class PaymentType {
    <<enum>>
    CASH, CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER;
}

class BoxgearType {
     <<enum>>
    AUTO, MANUAL;
}

class EmployeeType {
    <<enum>>
    MANAGER, DEPUTY_MANAGER, SELLER;
}

class CustomerType {
    <<enum>>
    PF, PJ;
}

class VehicleType {
    <<enum>>
    CAR, MOTOCYCLE;
}
```

# Recursos Do Projeto

## Backend

- Hibernate/JPA.
- H2DB.
- PostGreeSQL.
- Lombok.
- OpenAPI/Swagger.
- SOLID.
- MVC.
- Spring Boot.
- Java 17.

# Funcionalidades 

## Funcionários 

- Registra funcionário.
- Atualiza funcionário.
- Lista funcionários.

## Veículos

- Registra veículo.
- Atualiza veículo.
- Lista veículo pelo modelo.

## Marca

- Registra marca.
- Atualiza marca.
- Lista marca pelo nome.

## Modelo

- Registra modelo.
- Atualiza modelo.
- Lista modelo pelo nome.

## Cliente

- Registra cliente.
- Atualizar cliente.
- Procurar cliente pelo documento.

# Requisições 

## Registra funcionário.

```json
/api/employees/register-employee

{
  "name": "",
  "email": "",
  "matriculation": "",
  "phone": "",
  "birthDate": "2025-08-19",
  "employeeType": "MANAGER",
  "commission": 0
}
```

## Atualiza funcionário.

```json
/api/employees/register-employee

{
  "name": "",
  "email": "",
  "matriculation": "",
  "phone": "",
  "birthDate": "2025-08-19",
  "employeeType": "MANAGER",
  "commission": 0
}
```

## Lista funcionários.



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
