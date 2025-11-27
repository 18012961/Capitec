import ProgressBar from "./ProgressBar";
import './style.css';

export default function Results({ data }) {
  const { eligibilityResult, recommendedLoan, affordabilityAnalysis } = data;

  return (
    <div className="results">
      <p>
        With an interest rate of <strong>{recommendedLoan.interestRate}%</strong> over{" "}
        <strong>{recommendedLoan.loanTerm || "your selected term"} months</strong>,
        you will pay <strong>R{recommendedLoan.monthlyPayment}</strong> per month.
      </p>

      <div className="results-grid">
        <div className="circle">
          <h3>{eligibilityResult.approvalLikelihood}%</h3>
          <span>Approval Chance</span>
        </div>

        <div>
          <h4>Monthly Payment</h4>
          <ProgressBar value={recommendedLoan.monthlyPayment} max={10000} />
        </div>

        <div>
          <h4>Total Interest</h4>
          <ProgressBar value={recommendedLoan.totalRepayment} max={200000} />
        </div>
      </div>
    </div>
  );
}
