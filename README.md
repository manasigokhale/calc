# Calculator Microservice

## Overview

This project implements a simple, extensible calculator as a Spring Boot microservice using Java 17. It adheres to the Open-Closed Principle and is designed with maintainability and extensibility in mind.

## Design Decisions

- **Open-Closed Principle**: New operations can be added by creating new implementations of the `CalculatorOperation` interface without modifying existing code.
- **Inversion of Control**: Used Spring's IoC container to manage dependencies, allowing for easy testing and swapping of implementations.
- **Error Handling**: Custom exceptions are used to handle invalid operations gracefully.
- **Extensibility**: The calculator can be extended by simply adding new operation classes and updating the `OperationType` enum.

## Testing

Unit tests are provided for each operation and the calculator itself, covering normal and edge cases.

## Running the Application

1. Ensure you have Java 17 and Maven installed.
2. Build the project:

   ```bash
   mvn clean install
   
## REST API Endpoints

### Perform a Single Calculation

- **URL**: `/api/calculator/calculate`
- **Method**: `POST`
- **Content-Type**: `application/json`
- **Request Body**:

  ```json
  {
    "operation": "ADD",
    "num1": 5,
    "num2": 3
  }

### Example Usage**

You can test the endpoints using tools like **Postman** or **cURL**.

#### **Using cURL for Single Calculation**

```bash
curl -X POST \
  http://localhost:8080/api/calculator/calculate \
  -H 'Content-Type: application/json' \
  -d '{
        "operation": "SUBTRACT",
        "num1": 10,
        "num2": 4
      }'

curl -X POST \
  http://localhost:8080/api/calculator/calculate-sequential \
  -H 'Content-Type: application/json' \
  -d '{
        "initialValue": 5,
        "operations": ["ADD", "MULTIPLY"],
        "operands": [3, 2]
      }'
