import React from "react";

function VocaBook({ categories }) {
  return (
    <div>
      {Object.entries(categories).map(([vocaBookId, categoryArray]) => (
        <div key={vocaBookId}>
          <h2>VocaBook ID: {vocaBookId}</h2>
          {categoryArray.map((category, index) => (
            <p key={index}>{category}</p>
          ))}
        </div>
      ))}
    </div>
  );
}

export default React.memo(VocaBook);
