package com.loan.app.model;

public class ValidationRules {
    private int minAge, maxAge, minEmploymentDuration;
    private double minMonthlyIncome, minRequestedAmount, maxRequestedAmount;
    private int minLoanTerm, maxLoanTerm;

    public int getMinAge(){return minAge;} public void setMinAge(int v){this.minAge=v;}
    public int getMaxAge(){return maxAge;} public void setMaxAge(int v){this.maxAge=v;}
    public int getMinEmploymentDuration(){return minEmploymentDuration;} public void setMinEmploymentDuration(int v){this.minEmploymentDuration=v;}
    public double getMinMonthlyIncome(){return minMonthlyIncome;} public void setMinMonthlyIncome(double v){this.minMonthlyIncome=v;}
    public double getMinRequestedAmount(){return minRequestedAmount;} public void setMinRequestedAmount(double v){this.minRequestedAmount=v;}
    public double getMaxRequestedAmount(){return maxRequestedAmount;} public void setMaxRequestedAmount(double v){this.maxRequestedAmount=v;}
    public int getMinLoanTerm(){return minLoanTerm;} public void setMinLoanTerm(int v){this.minLoanTerm=v;}
    public int getMaxLoanTerm(){return maxLoanTerm;} public void setMaxLoanTerm(int v){this.maxLoanTerm=v;}
}
