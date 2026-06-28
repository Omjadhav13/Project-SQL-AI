import "./App.css";
import React, { useState } from "react";

import Header from "./components/Header";
import SqlInput from "./components/SqlInput";
import AnalyzeButton from "./components/AnalyzeButton";
import ResultCard from "./components/ResultCard";

import { analyzeQuery } from "./api/analyzerApi";

function App() {

  const [query, setQuery] = useState("");
  const [analyzedResult, setAnalyzedResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleAnalyze = async () => {

    setLoading(true);

    setError("");

    setAnalyzedResult(null);

    try {

      const result = await analyzeQuery(query);

      setAnalyzedResult(result);

    } catch (e) {

      console.error(e);

      if (e.response) {
        setError(e.response.data);
      } else {
        setError("Unable to connect to the server.");
      }

    } finally {

      setLoading(false);

    }

  };

  return (
    <div>

      <Header />

      <SqlInput
        query={query}
        setQuery={setQuery}
      />

      <AnalyzeButton
        onAnalyze={handleAnalyze}
      />

      {loading && <h2>Analyzing...</h2>}

      {error && (
        <p style={{ color: "red" }}>
          {error}
        </p>
      )}

      {analyzedResult && (
        <>
          <ResultCard
            title="Query Type"
            content={analyzedResult.queryType}
          />

          <ResultCard
            title="Parsing"
            content={analyzedResult.parsing}
          />

          <ResultCard
            title="Optimization"
            content={analyzedResult.optimization}
          />

          <ResultCard
            title="Execution"
            content={analyzedResult.execution}
          />

          <ResultCard
            title="Result Generation"
            content={analyzedResult.resultGeneration}
          />
        </>
      )}

    </div>
  );
}

export default App;