package com.loan.app.model;

import java.util.List;

public class RateResponse {
    private double interestRate;
    private double monthlyPayment;
    private double totalInterest;
    private double totalRepayment;
    private List<Payment> paymentSchedule;

    public double getInterestRate(){return interestRate;} public void setInterestRate(double v){this.interestRate=v;}
    public double getMonthlyPayment(){return monthlyPayment;} public void setMonthlyPayment(double v){this.monthlyPayment=v;}
    public double getTotalInterest(){return totalInterest;} public void setTotalInterest(double v){this.totalInterest=v;}
    public double getTotalRepayment(){return totalRepayment;} public void setTotalRepayment(double v){this.totalRepayment=v;}
    public List<Payment> getPaymentSchedule(){return paymentSchedule;} public void setPaymentSchedule(List<Payment> v){this.paymentSchedule=v;}
}
