import React from 'react'

function Header(props) {
  return (
    <div>
        <h1>SQL Query Analyzer</h1>
        <hr />
        <h3>Understand how SQL works internally</h3>

        <h4>Hello {props.setName}</h4>
    </div>
  )
}

export default Header