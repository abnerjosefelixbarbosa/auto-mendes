# auto-mendes 

## Sobre

Sistema da concessionária Auto Mendes.

## Modelo

```mermaid
classDiagram
    class Customer {
        - id: String
        - document: String
        - name: String
        - email: String
        - phone: String
    }

    class PF {
    }

    class PJ {
    }

    class Employee {
        - id: String
        - name: String
        - email: String
        - matriculation: String
        - phone: String
        - birthDate: LocalDate
    }

    class Manager {
    }

    class AssistantManager {
    }

    class Saler {
        - commission: BigDecimal
    }
    
    class Sale {
        - id: String
        - dateTime: LocalDateTime
        - paymentType: PaymentType
        - total: BigDecimal 
    }
    
    class SaleVehicle {
        - saleVehicleId: SaleVehicleId 
        - quantity: Integer
    }
    
    class SaleVehicleId {
        - saleId: String
        - vehicleId: String
    } 

    class Vehicle {
        - id: String
        - plate: String
        - transmissionType: TransmissionType
        - price: BigDecimal
    }

    class Car {
    }

    class Motorcycle {
    }

    class Model {
        - id: String
        - name: String
    }

    class Brand {
        - id: String
        - name: String
    }
    
    class PaymentType {
        <<enumeration>>
        CASH, CREDIT_CARD, DEBIT_CARD, PIX, BANK_TRANSFER;
    }
    
    class TransmissionType {
        <<enumeration>>
        AUTO, MANUAL;
    }

    Customer "1" -- "*" Sale
    Saler "1" -- "*" Sale
    Sale "1" -- "*" SaleVehicle
    Vehicle "1" -- "*" SaleVehicle
    Model "1" -- "*" Vehicle
    Brand "1" -- "*" Model
    SaleVehicleId  -- SaleVehicle
    Sale -- PaymentType
    Vehicle -- TransmissionType 

    Customer <|-- PF
    Customer <|-- PJ
    Employee <|-- Manager
    Employee <|-- AssistantManager
    Employee <|-- Saler
    Vehicle <|-- Car
    Vehicle <|-- Motorcycle
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

# Requisitos Funcionais 

## Funcionários 

- Registrar funcionário.
- Atualizar funcionário pelo id.
- Listar funcionários pelo tipo.

# Requisições 

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
