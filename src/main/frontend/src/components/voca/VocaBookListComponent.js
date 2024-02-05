import React from "react";
import VocaBookComponent from "./VocaBookComponent";
function VocaBookListComponent({vocaBooks}){
  return(
    <>
      {vocaBooks.map(vocaBook=>{
        return <VocaBookComponent key={vocaBook.id} name={vocaBook.name} vocaBookId={vocaBook.id}/>
      })}
    </>
  )
}

export default React.memo(VocaBookListComponent);