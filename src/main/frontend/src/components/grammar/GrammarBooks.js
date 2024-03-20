import React, { useEffect, useState } from "react";
import { Button, Card, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function GrammarBooks({grammarBooks})  {
  const navigate = useNavigate();
  return (
    <>
      {grammarBooks && grammarBooks.map((grammarBook) => (
      <Container key={grammarBook.id} className="d-flex justify-content-center mt-3">
        <Card key={grammarBook.id} style={{ width: '18rem' }} border="info" className="text-center">
          <Card.Img variant="top" src={grammarBook.imageURL} />
          <Card.Body>
            <Card.Title className="fw-bold">{grammarBook.name}</Card.Title>
            <Container className="d-flex justify-content-center mt-3">
            <Button onClick={() => navigate(`/grammarbooks/${grammarBook.id}`)} variant="success">✏️공부하기!✏️</Button>
            </Container>
          </Card.Body>
        </Card>
        <br />
      </Container>
      ))}
  
    </>
  )
}

export default React.memo(GrammarBooks);

