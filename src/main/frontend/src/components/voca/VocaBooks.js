import React from "react";
import { Button, Card, Container } from "react-bootstrap";

function VocaBooks({vocaBooks})  {
  console.log(vocaBooks);
  return (
    <>
      {vocaBooks && Object.entries(vocaBooks).map(([key, value]) => (
      <Container className="d-flex justify-content-center mt-3">
        <Card key={key} style={{ width: '18rem' }} border="info" className="text-center">
          <Card.Img variant="top" src="holder.js/100px180" />
          <Card.Body>
            <Card.Title className="fw-bold">{value}</Card.Title>
            <Container className="d-flex justify-content-center mt-3">
            <Button variant="outline-info">공부하기!✏️</Button>
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
