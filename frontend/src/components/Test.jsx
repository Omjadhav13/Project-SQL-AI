import React, { useState } from 'react';

export default function Test() {

    const [text, setText] = useState("");

    const changesOnButton = () => {
        console.log("clicked");
        setText(text + " hi");
    };

    const changesOnChange = (e) => {
        console.log("OnChange");
        setText(e.target.value );
    };

    return (
        <div>
            <textarea
                value={text}
                onChange={changesOnChange}
            />

            <button onClick={changesOnButton}>
                Test
            </button>
        </div>
    );
}