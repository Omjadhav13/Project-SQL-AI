import './App.css'
import AnalyzeButton from './components/AnalyzeButton';
import Header from './components/Header';
import ResultCard from './components/ResultCard';
import SqlInput from './components/SqlInput';
import React,{useState} from 'react';
import Test from './components/Test';

function App() {
  const [query, setQuery] = useState("");
  return (
    <div>
      <Header setName="Om"/>
      <SqlInput query={query} setQuery={setQuery}/>
      <AnalyzeButton query={query}/>
      <ResultCard/>
      <Test/>
    </div>
  )
}

export default App;
