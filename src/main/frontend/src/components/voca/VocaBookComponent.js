import React from "react";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";



function VocaBookComponent({name,vocaBookId}){
  const navigate = useNavigate();
  const onClickToDetail = () => {
    navigate(`/vocabook/detail/${vocaBookId}`);
  }
  
  return (
    <div className="d-grid gap-2">
      <Button onClick={onClickToDetail} variant="primary" size="lg">
        {name === 'TOEIC' ? `TOEIC🦹` : name === 'BASIC' ? `BASIC👨🏻‍🏫` : name}
      </Button>
      <br />
    </div>
  )
}


export default React.memo(VocaBookComponent);