package com.loan.app.controller;

import com.loan.app.model.*;
import com.loan.app.service.MockLoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class ApiController {

    private final MockLoanService service = new MockLoanService();

    @GetMapping("/products")
    public ResponseEntity<ProductsResponse> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/validation-rules")
    public ResponseEntity<ValidationRules> getValidationRules() {
        return ResponseEntity.ok(service.getValidationRules());
    }

    @PostMapping("/eligibility")
    public ResponseEntity<LoanResponse> checkEligibility(@RequestBody LoanRequest req) {
        return ResponseEntity.ok(service.checkEligibility(req));
    }

    @PostMapping("/calculate-rate")
    public ResponseEntity<RateResponse> calculateRate(@RequestBody RateRequest req) {
        return ResponseEntity.ok(service.calculateRate(req));
    }
}
