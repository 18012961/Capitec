package com.loan.app.model;

public class Payment {
    private int month;
    private double payment, principal, interest, balance;
    public int getMonth(){return month;} public void setMonth(int v){this.month=v;}
    public double getPayment(){return payment;} public void setPayment(double v){this.payment=v;}
    public double getPrincipal(){return principal;} public void setPrincipal(double v){this.principal=v;}
    public double getInterest(){return interest;} public void setInterest(double v){this.interest=v;}
    public double getBalance(){return balance;} public void setBalance(double v){this.balance=v;}
}
