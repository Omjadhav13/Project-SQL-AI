import './App.css'
import AnalyzeButton from './components/AnalyzeButton';
import Header from './components/Header';
import ResultCard from './components/ResultCard';
import SqlInput from './components/SqlInput';
import React, { useState } from 'react';
import { analyzeQuery } from './api/analyzerApi';

function App() {
  const [query, setQuery] = useState("");
  const [analyzedResult, setAnalyzedResult] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [Error, setError] = useState("");
  const handleAnalyze = async () => {
    setLoading(true);
    setError("");
    try {
      const result = await analyzeQuery(query);
      setAnalyzedResult(result);
    }
    catch (e) {
      console.log(e.message);
    }
    finally {
      setLoading(false);
    }

  }
  return (
    <div>
      <Header />
      <SqlInput query={query} setQuery={setQuery} />
      <AnalyzeButton onAnalyze={handleAnalyze} />
      {loading && <h2>Analyzing...</h2>}

      {error && <p>{error}</p>}

      {analysisResult && (
        <>
          <ResultCard
            title="Query Type"
            content={analysisResult.queryType}
          />
          <ResultCard
            title="Parsing"
            content={analysisResult.parsing}
          />
          <ResultCard
            title="Optimization"
            content={analysisResult.optimization}
          />
          <ResultCard
            title="Execution"
            content={analysisResult.execution}
          />
          <ResultCard
            title="Result Generation"
            content={analysisResult.resultGeneration}
          />
        </>
      )}
    </div>
  );
}
export default App;
