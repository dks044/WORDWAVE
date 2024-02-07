import React from "react";
import { Button, Card } from "react-bootstrap";

function VocaBooks({vocaBooks})  {
  console.log(vocaBooks);
  return (
    <>
      {vocaBooks && Object.entries(vocaBooks).map(([key, value]) => (
      <Card key={key} style={{ width: '18rem' }}>
        <Card.Img variant="top" src="holder.js/100px180" />
        <Card.Body>
          <Card.Title>{key}</Card.Title>
          <Card.Text>
            {value}
          </Card.Text>
          <Button variant="primary">Go somewhere</Button>
        </Card.Body>
      </Card>
      ))}
    </>
  )
}

export default React.memo(VocaBooks);
