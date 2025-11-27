import { useState } from "react";
import './style.css';

export default function CompareRate({ onChange }) {
  const [data, setData] = useState({
    rate: "",
    term: ""
  });

  const update = (field, value) => {
    const updated = { ...data, [field]: value };
    setData(updated);
    onChange(updated);
  };

  return (
    <div className="form-grid">
      <div>
        <label>Interest Rate (%)</label>
        <input type="number" placeholder="2.0"
          onChange={e => update("rate", e.target.value)} />
      </div>

      <div>
        <label>Loan Term</label>
        <select onChange={e => update("term", e.target.value)}>
          <option value="">Select</option>
          <option value="12">12 months</option>
          <option value="24">24 months</option>
          <option value="36">36 months</option>
        </select>
      </div>
    </div>
  );
}
