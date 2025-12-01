package com.loan.app.model;

public class Product {
    private String id, name, description;
    private double minAmount, maxAmount;
    private int minTerm, maxTerm;
    private double interestMin, interestMax;
    private String[] purposes;

    public String getId(){return id;} public void setId(String v){this.id=v;}
    public String getName(){return name;} public void setName(String v){this.name=v;}
    public String getDescription(){return description;} public void setDescription(String v){this.description=v;}
    public double getMinAmount(){return minAmount;} public void setMinAmount(double v){this.minAmount=v;}
    public double getMaxAmount(){return maxAmount;} public void setMaxAmount(double v){this.maxAmount=v;}
    public int getMinTerm(){return minTerm;} public void setMinTerm(int v){this.minTerm=v;}
    public int getMaxTerm(){return maxTerm;} public void setMaxTerm(int v){this.maxTerm=v;}
    public double getInterestMin(){return interestMin;} public void setInterestMin(double v){this.interestMin=v;}
    public double getInterestMax(){return interestMax;} public void setInterestMax(double v){this.interestMax=v;}
    public String[] getPurposes(){return purposes;} public void setPurposes(String[] v){this.purposes=v;}
}
