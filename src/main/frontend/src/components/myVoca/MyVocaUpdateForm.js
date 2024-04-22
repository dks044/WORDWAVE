import React, { useState } from "react";
import { Button, Col, FloatingLabel, Form, Row } from "react-bootstrap";
import { useDispatch } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";
import {updateMyVocaAPI} from "../../api/myVocaAPI";

const Title = styled.h1`
  font-weight: bolder;
  text-align: center;
`
const Hr = styled.hr`
  width: 85%;
  margin: 0px auto;
`
const StyledRow = styled(Row)`
  margin-bottom: 10px; 
`;
const SubTitle = styled.h3`
  text-align: center;
  font-weight: bolder;
`

function MyVocaUpdateForm({myVoca,userId}){
  const dispatch = useDispatch();

  // 입력 필드 상태 관리
  const [inputFields, setInputFields] = useState(myVoca ? myVoca.myVocas : []);

  // 필드 추가 함수
  const handleAddFields = () => {
    const newFields = { engWord: '', korWord: '' };
    setInputFields([...inputFields, newFields]);
  };

  // 입력 변경 처리 함수
  const handleInputChange = (index, event) => {
    const values = [...inputFields];
    if (event.target.name === "engWord") {
      values[index].engWord = event.target.value;
    } else {
      values[index].korWord = event.target.value;
    }
    setInputFields(values);
  };

  // 폼 제출 함수
  const handleSubmit = async (event) => {
    event.preventDefault();
    const category = event.target.elements.floatingInputCategory.value;


    // 카테고리 유효성 검사
    if (!category) {
      dispatch(showPopup('카테고리를 입력해주세요.'));
      return;
    }

    // inputFields 내의 모든 필드에 대한 유효성 검사
    const hasEmptyField = inputFields.some(field => field.engWord.trim() === '' || field.korWord.trim() === '');

    if (hasEmptyField) {
      dispatch(showPopup('모든 영단어와 한글단어 칸을 채워주세요.'));
      return;
    }

    try {
      await updateMyVocaAPI(myVoca.myVocaBookId,userId,myVoca.category,category,inputFields);
      window.location.href = `/myvocabooks/${myVoca.myVocaBookId}`;
    } catch (error) {
      dispatch(showPopup('해당 카테고리는 해당 영어단어장에 존재합니다, 다른 이름으로 수정해주세요.'));
    }
  };
  
  if(!myVoca) return null;

  return(
    <>
      <br />
      <Title>나만의 영단어 수정하기</Title>
      <SubTitle>카테고리 이름 : {myVoca.category}</SubTitle>
      <Hr />
      <br/>
      <Form onSubmit={handleSubmit}>
        <FloatingLabel controlId="floatingInputCategory" label="영단어 카테고리 입력">
            <Form.Control type="text"
            placeholder="카테고리"/>
        </FloatingLabel>
        <br/>
        {inputFields.map((inputField, index) => (
          <StyledRow className="g-2" key={index}> 
            <Col md={5}>
              <FloatingLabel label="영단어 입력">
                <Form.Control
                  type="text"
                  name="engWord"
                  value={inputField.engWord}
                  onChange={event => handleInputChange(index, event)}
                />
              </FloatingLabel>
            </Col>
            <Col md={5}>
              <FloatingLabel label="한글단어 입력">
                <Form.Control
                  type="text"
                  name="korWord"
                  value={inputField.korWord}
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

export default React.memo(MyVocaUpdateForm);