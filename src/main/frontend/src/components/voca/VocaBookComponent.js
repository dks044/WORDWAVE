import React from "react";
import { Button } from "react-bootstrap";

function VocaBookComponent({name}){
  return (
    <div className="d-grid gap-2">
      <Button variant="primary" size="lg">
        {name === 'TOEIC' ? `TOEIC🦹🏻‍♂️` : ''}
        {name === 'BASIC' ? `BASIC👨🏻‍🏫` : ''}
      </Button>
      <br />
    </div>
  )
}


export default React.memo(VocaBookComponent);