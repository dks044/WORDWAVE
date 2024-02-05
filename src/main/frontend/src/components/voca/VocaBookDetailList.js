import React from "react";
import VocaBookDetail from "./VocaBookDetail";
function VocaBookDetailList({categories}){
  return (
    <>
      {categories.map(category=>{
          return <VocaBookDetail key={category.id} category={category.category}/>
        })}
    </>
  )
}