import React from "react";
import { Button } from "react-bootstrap";

function VocaBookComponent({id, name}){
  return (
    <div className="d-grid gap-2">
      <Button variant="primary" size="lg">
        {name}
      </Button>
    </div>
  )
}


export default React.memo(VocaBookComponent);