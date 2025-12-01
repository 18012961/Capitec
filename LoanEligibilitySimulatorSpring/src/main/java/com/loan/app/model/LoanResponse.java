package com.loan.app.model;

public class LoanResponse {
    private boolean isEligible;
    private int approvalLikelihood;
    private String riskCategory;
    private String decisionReason;

    private double maxAmount;
    private double recommendedAmount;
    private double interestRate;
    private double monthlyPayment;
    private double totalRepayment;

    private double disposableIncome;
    private double debtToIncomeRatio;
    private double loanToIncomeRatio;
    private String affordabilityScore;

    // getters and setters
    public boolean isEligible(){return isEligible;} public void setEligible(boolean v){this.isEligible=v;}
    public int getApprovalLikelihood(){return approvalLikelihood;} public void setApprovalLikelihood(int v){this.approvalLikelihood=v;}
    public String getRiskCategory(){return riskCategory;} public void setRiskCategory(String v){this.riskCategory=v;}
    public String getDecisionReason(){return decisionReason;} public void setDecisionReason(String v){this.decisionReason=v;}
    public double getMaxAmount(){return maxAmount;} public void setMaxAmount(double v){this.maxAmount=v;}
    public double getRecommendedAmount(){return recommendedAmount;} public void setRecommendedAmount(double v){this.recommendedAmount=v;}
    public double getInterestRate(){return interestRate;} public void setInterestRate(double v){this.interestRate=v;}
    public double getMonthlyPayment(){return monthlyPayment;} public void setMonthlyPayment(double v){this.monthlyPayment=v;}
    public double getTotalRepayment(){return totalRepayment;} public void setTotalRepayment(double v){this.totalRepayment=v;}
    public double getDisposableIncome(){return disposableIncome;} public void setDisposableIncome(double v){this.disposableIncome=v;}
    public double getDebtToIncomeRatio(){return debtToIncomeRatio;} public void setDebtToIncomeRatio(double v){this.debtToIncomeRatio=v;}
    public double getLoanToIncomeRatio(){return loanToIncomeRatio;} public void setLoanToIncomeRatio(double v){this.loanToIncomeRatio=v;}
    public String getAffordabilityScore(){return affordabilityScore;} public void setAffordabilityScore(String v){this.affordabilityScore=v;}
}
