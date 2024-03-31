import React, { useState } from "react";
import { Alert, Button, FloatingLabel, Form } from "react-bootstrap";
import styled from "styled-components";

const Title = styled.h1`
  font-weight: bolder;
  text-align: center;
`

function MyVocaBookForm(){
  const [fileError, setFileError] = useState(""); // 파일 에러 상태메시지
  const [isFileError,setIsFileError] = useState(false) //파일 에러 유무 

  const handleFileChange = (e) => {
    const file = e.target.files[0]; 
    if (file) {
      // 파일 크기 검증
      if (file.size > 2 * 1024 * 1024) { // 2MB 이상인 경우
        setFileError("파일 크기는 2MB 이하이어야 합니다.");
        setIsFileError(true);
        return; // 추가 검증 중단
      }
      // 파일 타입 검증
      if (!file.type.startsWith('image/')) { // 이미지 파일이 아닌 경우
        setFileError("이미지 파일만 업로드 가능합니다.");
        setIsFileError(true);
        return; 
      }
      // 문제가 없으면 에러 메시지 초기화
      setFileError("");
    }
  };

  return(
    <>
      <br /><br /><br /><br />
      <Title>나만의 단어장 만들기😎</Title>
      <hr />
      <div className="d-grid gap-2">
        <Form >
          <FloatingLabel
              controlId="floatingInputMyVocaBookName"
              label="단어장 이름 입력!"
              className="mb-3"
            >
              <Form.Control type="text" placeholder="나만의 단어장 이름을 입력하세요" name="name" maxlength='10'/>
          </FloatingLabel>
          <Form.Group controlId="formFileLg" className="mb-3">
            <Form.Label>썸네일 이미지 입력</Form.Label>
            <Form.Control type="file" size="lg" onChange={handleFileChange} />
            {fileError && <Alert variant="danger">{fileError}</Alert>} {/* 에러 메시지 표시 */}
          </Form.Group>
          <div className="d-grid gap-2">
            <Button variant="outline-primary" type="submit">만들기</Button>
          </div>
        </Form>
      </div>
    </>
  )
}

export default React.memo(MyVocaBookForm);