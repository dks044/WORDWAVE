import React from "react";
import { Button } from "react-bootstrap";

function VocaBookComponent({vocaBook}){
  return (
    <div className="d-grid gap-2">
      <Button variant="primary" size="lg">
        {vocaBook.name}
      </Button>
    </div>
  )
}


export default React.memo(VocaBookComponent);