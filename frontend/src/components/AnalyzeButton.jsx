import React from 'react'
import App from '../App'

function  AnalyzeButton({query})  {
  const onAnalyze = ()=>{
    console.log(query);
  }
  return (
    <button onClick={onAnalyze}>Analyze</button>
  ) 
}

export default AnalyzeButton