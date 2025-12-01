Loan Eligibility Simulator - Spring Boot Web App

Run:
  mvn spring-boot:run

Open:
  http://localhost:8085/index.html

Features:
- Mocked API endpoints:
  GET /api/loans/products
  GET /api/loans/validation-rules
  POST /api/loans/eligibility
  POST /api/loans/calculate-rate
- Client-side UI (static) consumes these endpoints.
