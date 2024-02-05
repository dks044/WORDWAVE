import React from "react";
import VocaBookDetail from "./VocaBookDetail";

export default function VocaBookDetailList({categories}){
  return (
    <>
      {categories.map(category=>{
          return <VocaBookDetail key={category.id} category={category.category}/>
        })}
    </>
  )
}