import './App.css'
import AnalyzeButton from './components/AnalyzeButton';
import Header from './components/Header';
import ResultCard from './components/ResultCard';
import SqlInput from './components/SqlInput';
import React,{useState} from 'react';

function App() {
  const [query, setQuery] = useState("");
  const [analyzedQuery, setAnalyzedQuery] = useState("");
  const handleAnalyze=()=>{
    setAnalyzedQuery(query);
  }
  return (
    <div>
      <Header />
      <SqlInput query={query} setQuery={setQuery}/>
      <AnalyzeButton onAnalyze={handleAnalyze}/>
      <ResultCard title="Anlayzed Query" content={analyzedQuery}/>
    </div>
  )
}

export default App;
