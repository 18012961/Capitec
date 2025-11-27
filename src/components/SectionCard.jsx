export default function SectionCard({ number, title, children }) {
  return (
    <div className="card">
      <div className="card-header">
        <span className="section-number">{number}</span>
        <h2>{title}</h2>
      </div>
      {children}
    </div>
  );
}
