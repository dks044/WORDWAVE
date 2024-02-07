import React from "react";
import { Button, Card, Container } from "react-bootstrap";

function VocaBooks({vocaBooks})  {
  console.log(vocaBooks);
  return (
    <>
      {vocaBooks && vocaBooks.map((vocaBook) => (
      <Container className="d-flex justify-content-center mt-3">
        <Card key={vocaBook.id} style={{ width: '18rem' }} border="info" className="text-center">
          <Card.Img variant="top" src={vocaBook.imageURL} />
          <Card.Body>
            <Card.Title className="fw-bold">{vocaBook.name}</Card.Title>
            <Container className="d-flex justify-content-center mt-3">
            <Button variant="success">✏️공부하기!✏️</Button>
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

