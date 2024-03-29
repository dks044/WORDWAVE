import React, { useEffect, useState } from "react";
import { Button, Card, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function VocaBooks({vocaBooks})  {
  const navigate = useNavigate();
  return (
    <>
      {vocaBooks && vocaBooks.map((vocaBook) => (
      <Container key={vocaBook.id} className="d-flex justify-content-center mt-3">
        <Card key={vocaBook.id} style={{ width: '18rem' }} border="info" className="text-center">
          <Card.Img variant="top" src={vocaBook.imageURL} />
          <Card.Body>
            <Card.Title className="fw-bold">{vocaBook.name}</Card.Title>
            <Container className="d-flex justify-content-center mt-3">
            <Button onClick={() => navigate(`/vocabooks/${vocaBook.id}`)} variant="success">✏️공부하기!✏️</Button>
            </Container>
          </Card.Body>
        </Card>
        <br />
      </Container>
      ))}
  
    </>
  )
}

export default React.memo(VocaBooks);

