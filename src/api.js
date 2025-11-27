export async function calculateEligibility(formData) {
  // Mocked backend response
  return {
    eligibilityResult: {
      isEligible: true,
      approvalLikelihood: 85,
      riskCategory: "low"
    },
    recommendedLoan: {
      interestRate: 12.5,
      monthlyPayment: 289,
      totalRepayment: 170148
    },
    affordabilityAnalysis: {
      disposableIncome: 10000,
      debtToIncomeRatio: 20
    }
  };
}
