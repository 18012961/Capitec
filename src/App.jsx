import { useState } from "react";
import LoanInput from "./components/LoanInput";
import CompareRate from "./components/CompareRate";
import Results from "./components/Results";
import SectionCard from "./components/SectionCard";
import { calculateEligibility } from "./api";

export default function App() {
  const [formData, setFormData] = useState({});
  const [comparison, setComparison] = useState({});
  const [results, setResults] = useState(null);

  const handleCalculate = async () => {
    const response = await calculateEligibility(formData);
    setResults(response);
  };

  return (
    <div className="container">
      <h4 className="tag">SAVINGS CALCULATOR</h4>
      <h1 className="title">Calculate Your Savings with Clear Credit AI</h1>

      <SectionCard number="1" title="Enter your current loan details">
        <LoanInput onChange={setFormData} />
      </SectionCard>

      <SectionCard number="2" title="Choose a rate to compare">
        <CompareRate onChange={setComparison} />
      </SectionCard>

      <SectionCard number="3" title="Check the results">
        {results && <Results data={results} />}
        <button className="btn" onClick={handleCalculate}>Check Rates</button>
        <p className="disclaimer">Checking rate won’t affect your credit score. Calculator results are for illustrative purposes only.</p>
      </SectionCard>
    </div>
  );
}
