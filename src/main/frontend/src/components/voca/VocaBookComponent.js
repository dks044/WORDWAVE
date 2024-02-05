import React from "react";
import { Button } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import styled from "styled-components";



function VocaBookComponent({name,vocaBookId}){
  const navigate = useNavigate();
  const onClickToDetail = () => {
    navigate(`/vocabooklist/vocabook/detail/${vocaBookId}`, { state: { vocaBookId } });
  }
  
  return (
    <div className="d-grid gap-2">
      <Button onClick={onClickToDetail} variant="primary" size="lg">
        {name === 'TOEIC' ? `TOEIC🦹` : ''}
        {name === 'BASIC' ? `BASIC👨🏻‍🏫` : ''}
      </Button>
      <br />
    </div>
  )
}


export default React.memo(VocaBookComponent);