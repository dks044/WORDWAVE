import React, { useState } from "react";
import { Alert, Button, FloatingLabel, Form } from "react-bootstrap";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";
import { createMyVocaBookAPI } from "../../api/myVocaAPI";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import Card from 'react-bootstrap/Card';
import {updateMyVocaBookAPI} from "../../api/myVocaAPI";

const Title = styled.h1`
  font-weight: bolder;
  text-align: center;
`
const CardWrapper = styled.div`
  display: flex;
  justify-content: center; // 가로 중앙 정렬
  align-items: center; // 세로 중앙 정렬
  margin-bottom: 20px; // 필요에 따라 마진 추가
`;


function MyVocaBookUpdateForm({myVocaBook}){
  const [fileError, setFileError] = useState(""); // 파일 에러 상태메시지
  const [isFileError,setIsFileError] = useState(false) //파일 에러 유무 
  const [fileName, setFileName] = useState();
  const [previewUrl, setPreviewUrl] = useState(myVocaBook ? myVocaBook.imageURL : null); // 이미지 미리보기 URL 상태 추가

  const {user} = useSelector(state=>state.auth);
  const [name, setName] = useState(myVocaBook ? myVocaBook.name : ''); // 초기값을 myVocaBook.name으로 설정
  
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleNameChange = (e) => {
    setName(e.target.value); // 사용자 입력에 따라 name 상태 업데이트
  };
  

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    setFileName(file);
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
      // FileReader를 사용하여 파일 읽기
      const reader = new FileReader();
      reader.onload = () => {
          setPreviewUrl(reader.result); 
        };
      reader.readAsDataURL(file); 
    }
  };

  const handleSubMit = async (event) => {
    event.preventDefault(); 

    var userId = user.id;
    var myVocaBookId = myVocaBook.id;

    if(!name){
      dispatch(showPopup('이름은 필수입력 입니다!'));
      return;
    }
  
    await updateMyVocaBookAPI(name, myVocaBookId,userId, fileName); 
    navigate('/myvocabooks');
    dispatch(showPopup('나만의 단어장 수정이 완료됐습니다.'));
  }
  if(!myVocaBook) return null;

  return(
    <div>
      <br /><br /><br /><br />
      <Title>나만의 단어장 수정하기</Title>
      <hr />
      <div className="d-grid gap-2">
        <Form >
          <FloatingLabel
              controlId="floatingInputMyVocaBookName"
              label="단어장 이름 입력!"
              className="mb-3"
            >
              <Form.Control onChange={handleNameChange} type="text" placeholder="나만의 단어장 이름을 입력하세요" name="name" maxlength='10' value={name}/>
          </FloatingLabel>
          <Form.Group controlId="formFileLg" className="mb-3">
            <Form.Label>썸네일 이미지 입력</Form.Label>
            {/*이미지 미리보기*/ }
            {previewUrl &&
            <CardWrapper>
              <Card style={{ width: '18rem' }}>
                <Card.Img variant="top" src={previewUrl} />
              </Card>
            </CardWrapper>
            } 
            <Form.Control type="file" size="lg" onChange={handleFileChange} />
            {fileError && <Alert variant="danger">{fileError}</Alert>} {/* 에러 메시지 표시 */}
          </Form.Group>
          <div className="d-grid gap-2">
            <Button onClick={handleSubMit} variant="outline-primary" type="submit">수정하기</Button>
          </div>
        </Form>
      </div>
      <br /><br /><br /><br /><br /><br /><br />
    </div>
  )
}

export default MyVocaBookUpdateForm;