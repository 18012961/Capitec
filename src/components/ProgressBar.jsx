export default function ProgressBar({ value, max }) {
  const percent = Math.min((value / max) * 100, 100);

  return (
    <div className="progress-wrapper">
      <div className="progress-bar" style={{ width: percent + "%" }}></div>
    </div>
  );
}
