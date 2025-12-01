package com.loan.app.model;

public class LoanRequest {
    private PersonalInfo personalInfo = new PersonalInfo();
    private FinancialInfo financialInfo = new FinancialInfo();
    private LoanDetails loanDetails = new LoanDetails();

    public PersonalInfo getPersonalInfo() { return personalInfo; }
    public FinancialInfo getFinancialInfo() { return financialInfo; }
    public LoanDetails getLoanDetails() { return loanDetails; }

    public static class PersonalInfo {
        private int age;
        private String employmentStatus;
        private int employmentDuration;
        public int getAge(){return age;} public void setAge(int age){this.age=age;}
        public String getEmploymentStatus(){return employmentStatus;} public void setEmploymentStatus(String s){this.employmentStatus=s;}
        public int getEmploymentDuration(){return employmentDuration;} public void setEmploymentDuration(int d){this.employmentDuration=d;}
    }

    public static class FinancialInfo {
        private double monthlyIncome;
        private double monthlyExpenses;
        private double existingDebt;
        private int creditScore;
        public double getMonthlyIncome(){return monthlyIncome;} public void setMonthlyIncome(double v){this.monthlyIncome=v;}
        public double getMonthlyExpenses(){return monthlyExpenses;} public void setMonthlyExpenses(double v){this.monthlyExpenses=v;}
        public double getExistingDebt(){return existingDebt;} public void setExistingDebt(double v){this.existingDebt=v;}
        public int getCreditScore(){return creditScore;} public void setCreditScore(int v){this.creditScore=v;}
    }

    public static class LoanDetails {
        private double requestedAmount;
        private int loanTerm;
        private String loanPurpose;
        public double getRequestedAmount(){return requestedAmount;} public void setRequestedAmount(double v){this.requestedAmount=v;}
        public int getLoanTerm(){return loanTerm;} public void setLoanTerm(int v){this.loanTerm=v;}
        public String getLoanPurpose(){return loanPurpose;} public void setLoanPurpose(String v){this.loanPurpose=v;}
    }
}
