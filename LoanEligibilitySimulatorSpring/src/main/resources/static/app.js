async function loadProducts(){
  const res = await fetch('/api/loans/products');
  const data = await res.json();
  const sel = document.getElementById('productSelect');
  sel.innerHTML = '';
  data.products.forEach(p=>{
    const opt = document.createElement('option');
    opt.value = p.id;
    opt.text = p.name;
    sel.appendChild(opt);
  });
  sel.onchange = populatePurposes;
  populatePurposes();
}

function populatePurposes(){
  const sel = document.getElementById('productSelect');
  const productId = sel.value;
  fetch('/api/loans/products').then(r=>r.json()).then(data=>{
    const p = data.products.find(x=>x.id===productId);
    const ps = document.getElementById('purposeSelect');
    ps.innerHTML = '';
    (p.purposes||[]).forEach(pu=>{
      const o = document.createElement('option'); o.value=pu; o.text=pu; ps.appendChild(o);
    });
  });
}

function readForm(){
  return {
    personalInfo: {
      age: parseInt(document.getElementById('age').value||0),
      employmentStatus: document.getElementById('employmentStatus').value,
      employmentDuration: parseInt(document.getElementById('employmentDuration').value||0)
    },
    financialInfo: {
      monthlyIncome: parseFloat(document.getElementById('monthlyIncome').value||0),
      monthlyExpenses: parseFloat(document.getElementById('monthlyExpenses').value||0),
      existingDebt: parseFloat(document.getElementById('existingDebt').value||0),
      creditScore: parseInt(document.getElementById('creditScore').value||0)
    },
    loanDetails: {
      requestedAmount: parseFloat(document.getElementById('requestedAmount').value||0),
      loanTerm: parseInt(document.getElementById('loanTerm').value||0),
      loanPurpose: document.getElementById('purposeSelect').value
    }
  };
}

async function checkEligibility(){
  const rules = await (await fetch('/api/loans/validation-rules')).json();
  const form = readForm();
  const err = validate(form,rules);
  const out = document.getElementById('result');
  if(err.length){
    out.textContent = 'Validation errors:\n' + err.join('\n');
    return;
  }
  const res = await fetch('/api/loans/eligibility',{method:'POST',headers:{'content-type':'application/json'},body:JSON.stringify(form)});
  const data = await res.json();
  out.textContent = JSON.stringify(data, null, 2);
}

async function calculateRate(){
  const form = readForm();
  const body = { loanAmount: form.loanDetails.requestedAmount, loanTerm: form.loanDetails.loanTerm, creditScore: form.financialInfo.creditScore, loanType: document.getElementById('productSelect').value };
  const res = await fetch('/api/loans/calculate-rate',{method:'POST',headers:{'content-type':'application/json'},body:JSON.stringify(body)});
  const data = await res.json();
  document.getElementById('result').textContent = JSON.stringify(data, null, 2);
}

function validate(form, rules){
  const errors = [];
  if(form.personalInfo.age < rules.minAge || form.personalInfo.age > rules.maxAge) errors.push('Age must be between ' + rules.minAge + ' and ' + rules.maxAge);
  if(form.personalInfo.employmentDuration < rules.minEmploymentDuration) errors.push('Minimum employment duration is ' + rules.minEmploymentDuration + ' months');
  if(form.financialInfo.monthlyIncome < rules.minMonthlyIncome) errors.push('Minimum monthly income is ' + rules.minMonthlyIncome);
  if(form.loanDetails.requestedAmount < rules.minRequestedAmount || form.loanDetails.requestedAmount > rules.maxRequestedAmount) errors.push('Requested amount must be between ' + rules.minRequestedAmount + ' and ' + rules.maxRequestedAmount);
  if(form.loanDetails.loanTerm < rules.minLoanTerm || form.loanDetails.loanTerm > rules.maxLoanTerm) errors.push('Loan term must be between ' + rules.minLoanTerm + ' and ' + rules.maxLoanTerm + ' months');
  return errors;
}

document.getElementById('checkBtn').addEventListener('click', checkEligibility);
document.getElementById('rateBtn').addEventListener('click', calculateRate);

loadProducts().catch(e=>console.error(e));
