import { div } from '@tensorflow/tfjs'
import React from 'react'

function SqlInput({ query, setQuery }) {
  return (
    <div>
        <h4>Enter your query</h4>
        <textarea  rows="10" 
            value={query}
            onChange={(e)=> setQuery(e.target.value)} 
            placeholder="Enter SQL query..."        
        />
    </div>
  )
}

export default SqlInput