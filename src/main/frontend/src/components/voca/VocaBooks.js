import React, { useEffect, useState } from "react";
import { Button, Card, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const Title = styled.h1`
  text-align: center;
  font-weight: bolder;
`
function VocaBooks({vocaBooks})  {
  const navigate = useNavigate();
  return (
    <>
      <Title>VOCA</Title>
      {vocaBooks && vocaBooks.map((vocaBook) => (
      <Container key={vocaBook.id} className="d-flex justify-content-center mt-3">
        <Card key={vocaBook.id} style={{ width: '18rem' }} border="info" className="text-center">
          {vocaBook.imageURL && (
            <Card.Img variant="top" src={vocaBook.imageURL} />
          )}
          {!vocaBook.imageURL && (
            <Card.Img variant="top" src={"https://cdn.pixabay.com/photo/2020/01/23/21/07/seascape-4788749_1280.jpg"} />
          )}
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

