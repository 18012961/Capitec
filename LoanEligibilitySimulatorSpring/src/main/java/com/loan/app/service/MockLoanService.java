package com.loan.app.service;

import com.loan.app.model.*;
import java.util.ArrayList;
import java.util.List;

public class MockLoanService {

    public LoanResponse checkEligibility(LoanRequest req) {
        LoanResponse response = new LoanResponse();
        response.setEligible(true);
        response.setApprovalLikelihood(85);
        response.setRiskCategory("low");
        response.setDecisionReason("Strong income-to-expense ratio and manageable existing debt");

        response.setMaxAmount(180000.00);
        response.setRecommendedAmount(req.getLoanDetails().getRequestedAmount());
        response.setInterestRate(12.5);
        response.setMonthlyPayment(7089.50);
        response.setTotalRepayment(170148.00);

        double disposable = req.getFinancialInfo().getMonthlyIncome() - req.getFinancialInfo().getMonthlyExpenses();
        response.setDisposableIncome(disposable);
        response.setDebtToIncomeRatio(20.0);
        response.setLoanToIncomeRatio(60.0);
        response.setAffordabilityScore("good");
        return response;
    }

    public ProductsResponse getProducts() {
        ProductsResponse resp = new ProductsResponse();
        List<Product> list = new ArrayList<>();

        Product p1 = new Product();
        p1.setId("personal_loan");
        p1.setName("Personal Loan");
        p1.setDescription("Flexible personal financing for various needs");
        p1.setMinAmount(5000.00);
        p1.setMaxAmount(300000.00);
        p1.setMinTerm(6);
        p1.setMaxTerm(60);
        p1.setInterestMin(10.5);
        p1.setInterestMax(18.5);
        p1.setPurposes(new String[] { "debt_consolidation", "home_improvement", "education", "medical", "other" });

        Product p2 = new Product();
        p2.setId("vehicle_loan");
        p2.setName("Vehicle Finance");
        p2.setDescription("Financing for new and used vehicles");
        p2.setMinAmount(50000.00);
        p2.setMaxAmount(1500000.00);
        p2.setMinTerm(12);
        p2.setMaxTerm(72);
        p2.setInterestMin(8.5);
        p2.setInterestMax(15.0);
        p2.setPurposes(new String[] { "new_vehicle", "used_vehicle" });

        list.add(p1);
        list.add(p2);
        resp.setProducts(list);
        return resp;
    }

    public ValidationRules getValidationRules() {
        ValidationRules rules = new ValidationRules();
        rules.setMinAge(18);
        rules.setMaxAge(65);
        rules.setMinEmploymentDuration(3);
        rules.setMinMonthlyIncome(5000.00);
        rules.setMinRequestedAmount(5000.00);
        rules.setMaxRequestedAmount(300000.00);
        rules.setMinLoanTerm(6);
        rules.setMaxLoanTerm(60);
        return rules;
    }

    public RateResponse calculateRate(RateRequest req) {
        RateResponse r = new RateResponse();
        double rate = 12.5;
        // simple mocked calculation
        r.setInterestRate(rate);
        double monthlyRate = rate / 100 / 12;
        double n = req.getLoanTerm();
        double denom = 1 - Math.pow(1 + monthlyRate, -n);
        double monthlyPayment = (req.getLoanAmount() * monthlyRate) / denom;
        r.setMonthlyPayment(round(monthlyPayment));
        r.setTotalInterest(round(monthlyPayment * n - req.getLoanAmount()));
        r.setTotalRepayment(round(monthlyPayment * n));

        // small payment schedule example (first two months)
        List<Payment> schedule = new ArrayList<>();
        double balance = req.getLoanAmount();
        for (int m = 1; m <= Math.min(2, (int)n); m++) {
            double interest = balance * monthlyRate;
            double principal = monthlyPayment - interest;
            balance -= principal;
            Payment p = new Payment();
            p.setMonth(m);
            p.setPayment(round(monthlyPayment));
            p.setPrincipal(round(principal));
            p.setInterest(round(interest));
            p.setBalance(round(balance));
            schedule.add(p);
        }
        r.setPaymentSchedule(schedule);
        return r;
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
