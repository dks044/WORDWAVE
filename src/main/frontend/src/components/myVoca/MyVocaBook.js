import React, { useState, useRef } from "react";
import { Button, Modal, Overlay, Popover } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { getUserLearnHistory } from "../../modules/userLearnPerformance/userLearnPerformance";

const Title = styled.h1`
  font-weight: bold;
  text-align: center;
`;
const RedP = styled.span`
  color: red;
`
const BlueP = styled.span`
  color: blue;
`
const GreenP = styled.p`
  color: green;
`

function MyVocaBook({ myVocaBook }) {
  console.log(myVocaBook)
  const [show, setShow] = useState({});
  const [target, setTarget] = useState(null);
  const ref = useRef(null);
  const navigate = useNavigate();
  const {user} = useSelector(state=>state.auth);
  const {userLearnHistory} = useSelector(state=>state.userLearnPerformance);
  const dispatch = useDispatch();
  const [selectedCategory, setSelectedCategory] = useState(null); //현재 선택된 카테고리를 저장

  //modal
  const [modalShow, setModalShow] = useState(false);
  const handleClose = () => setModalShow(false);
  const handleShow = (category) => {
    setModalShow(true);
    setSelectedCategory(category); // 현재 선택된 카테고리 저장
  };
  

  const handleClick = async (event,index,category) => {
    setShow((prevShow) => ({ ...prevShow, [index]: !prevShow[index] }));
    setTarget(event.target);
    await dispatch(getUserLearnHistory({ category: category, userId: user.id }));

  };

  function formatDateString(dateString) {
    const date = new Date(dateString);
    const options = { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', hour12: false };
    return new Intl.DateTimeFormat('ko-KR', options).format(date);
  }



  if (!myVocaBook) return null;
  return (
    <>
      <Title>{myVocaBook.name}</Title>
      <hr />
      <div ref={ref}>
        {myVocaBook.categories && myVocaBook.categories.map((category, index) => (
          <div key={index} style={{ width: '100%' }}>
            <Button
              variant="outline-primary"
              size="lg"
              style={{ marginBottom: "20px", width: '100%' }}
              onMouseOver={(event) => handleClick(event, index,category)}
              onMouseOut={(event) => handleClick(event, index,category)}
              onClick={() => handleShow(category)} //각 카테고리 버튼의 onClick 이벤트에서 handleShow 함수를 호출할 때 현재 카테고리를 인자로 전달.
            >
              {category}
            </Button>
            <Overlay
              show={show[index]}
              target={target}
              placement="right"
              container={ref.current}
              containerPadding={20}
            >
              <Popover id={`popover-contained-${index}`}>
                <Popover.Header as="h3">{category}</Popover.Header>
                <Popover.Body>
                  {(userLearnHistory.loading || !userLearnHistory.data) && (
                    <p>잠시만 기다려주세요...</p>
                  )}
                  {(userLearnHistory.data && !userLearnHistory.data.existence) && 
                    (
                      <p>학습이력이 존재하지 않아요.</p>
                    )
                  }
                  {(userLearnHistory.data && userLearnHistory.data.existence) && 
                    (
                    <>
                      <span>
                        <BlueP>정답: {userLearnHistory.data.answerCount} </BlueP>
                        <RedP>오답 : {userLearnHistory.data.wrongCount}</RedP>
                      </span>
                      <br/>
                      <GreenP>마지막 시도 : {formatDateString(userLearnHistory.data.lastAttempted)}</GreenP>
                    </>
                    )
                  }
                </Popover.Body>
              </Popover>
            </Overlay>
            <Modal
              show={modalShow}
              onHide={handleClose}
              backdrop="static"
              keyboard={false}
              size="lg"
            >
            <Modal.Header closeButton>
              <Modal.Title><Title>퀴즈 안내사항</Title></Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <h5>
              ☝️ 퀴즈 진행중 다른 페이지로 이동시 진행상황이 저장 되지 않습니다. (끝까지 해주세요!)<br/><br/>
              ✌️ '영어 입력 퀴즈' 와 '영어 객관식 퀴즈' 로 총 2종류가 구현되있으며, 랜덤으로 출제 됩니다.<br/><br/>
              </h5>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                나중에하기
              </Button>
              <Button onClick={() => navigate(`/myVocaBooks/${myVocaBook.id}/${selectedCategory}`)} 
              variant="primary">공부하기!</Button>
            </Modal.Footer>
          </Modal>
          </div>
        ))}
        <div className="d-grid gap-2">
          <Button variant="outline-primary">+</Button>
        </div>
      </div>
    </>
  );
}

export default React.memo(MyVocaBook);
