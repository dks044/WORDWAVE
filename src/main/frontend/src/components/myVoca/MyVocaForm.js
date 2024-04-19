import React, { useState } from "react";
import { Button, Col, FloatingLabel, Form, Row } from "react-bootstrap";
import styled from "styled-components";

const Title = styled.h2`
  font-weight: bolder;
  text-align: center;
`
const Hr = styled.hr`
  width: 75%;
  margin: 0px auto;
`
const StyledRow = styled(Row)`
  margin-bottom: 10px; 
`;


function MyVocaForm () {
   // 입력 필드 상태 관리
   const [inputFields, setInputFields] = useState([{ englishWord: '', koreanWord: '' }]);

   // 필드 추가 함수
   const handleAddFields = () => {
     const newFields = { englishWord: '', koreanWord: '' };
     setInputFields([...inputFields, newFields]);
   };
 
   // 입력 변경 처리 함수
   const handleInputChange = (index, event) => {
     const values = [...inputFields];
     if (event.target.name === "englishWord") {
       values[index].englishWord = event.target.value;
     } else {
       values[index].koreanWord = event.target.value;
     }
     setInputFields(values);
   };
 
   // 폼 제출 함수
   const handleSubmit = (event) => {
     event.preventDefault();
    
     console.log(inputFields);
   };



  return(
    <>
      <br />
      <Title>나만의 영단어 만들기😎</Title>
      <Hr />
      <br/>
      <FloatingLabel controlId="floatingInputGrid" label="영단어 카테고리 입력">
          <Form.Control type="email" placeholder="name@example.com" />
        </FloatingLabel>
      <br/>
      <Form onSubmit={handleSubmit}>
        {inputFields.map((inputField, index) => (
          <StyledRow className="g-2" key={index}> 
            <Col md={5}>
              <FloatingLabel label="영단어 입력">
                <Form.Control
                  type="text"
                  name="englishWord"
                  value={inputField.englishWord}
                  onChange={event => handleInputChange(index, event)}
                />
              </FloatingLabel>
            </Col>
            <Col md={5}>
              <FloatingLabel label="한글단어 입력">
                <Form.Control
                  type="text"
                  name="koreanWord"
                  value={inputField.koreanWord}
                  onChange={event => handleInputChange(index, event)}
                />
              </FloatingLabel>
            </Col>
            <Col md={2}>
              <Button variant="outline-primary" onClick={handleAddFields}>+</Button>
            </Col>
          </StyledRow>
          ))}
        <br />
        <div className="d-grid gap-2">
          <Button variant="outline-primary" type="submit">제출</Button>
        </div>
        <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
      </Form>
    </>
  )
}

export default MyVocaForm;
