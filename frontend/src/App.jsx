import './App.css'
import AnalyzeButton from './components/AnalyzeButton';
import Header from './components/Header';
import ResultCard from './components/ResultCard';
import SqlInput from './components/SqlInput';

function App() {

  return (
    <div>
      <Header/>
      <SqlInput/>
      <AnalyzeButton/>
      <ResultCard/>
    </div>
  )
}

export default App;
