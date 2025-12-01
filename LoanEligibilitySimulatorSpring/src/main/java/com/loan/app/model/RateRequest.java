package com.loan.app.model;

public class RateRequest {
    private double loanAmount;
    private int loanTerm;
    private int creditScore;
    private String loanType;
    public double getLoanAmount(){return loanAmount;} public void setLoanAmount(double v){this.loanAmount=v;}
    public int getLoanTerm(){return loanTerm;} public void setLoanTerm(int v){this.loanTerm=v;}
    public int getCreditScore(){return creditScore;} public void setCreditScore(int v){this.creditScore=v;}
    public String getLoanType(){return loanType;} public void setLoanType(String v){this.loanType=v;}
}
