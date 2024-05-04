import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getMyVoca } from "../../modules/myVoca/myVoca";
import { showPopup } from "../../modules/popup";
import CircleSpinner from "../../components/CircleSpinner";
import { ProgressBar } from "react-bootstrap";
import MyVoca from "../../components/myVoca/MyVoca";

const MyVocaContainerBlock = styled.div`

  overflow-y: scroll;
  text-align: center;
`
const ProgressBarBlock = styled.div`
  margin-bottom: 3%;
`

function MyVocaContainer({myVocaBookId,category}){
  const loading = useSelector((state) => state.myVoca.myVoca?.loading);
  const data = useSelector((state) => state.myVoca.myVoca?.data);
  const error = useSelector((state) => state.myVoca.myVoca?.error);
  const {user} = useSelector(state=>state.auth);

  const [stack, setStack] = useState([]); //voca퀴즈Stack
  const stackSize = stack.length;
  const [currentVoca, setCurrentVoca] = useState(null); //현재voca
  const [remaining, setRemaining] = useState(0); //남은단어
  const [total, setTotal] = useState(0);  // 전체 단어의 수
  //퀴즈 데이터 랜더링이 완료 됐는지
  const [isDataLoaded, setIsDataLoaded] = useState(false);

  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getMyVoca({myVocaBookId,userId:user.id,category}));
  }, [dispatch, myVocaBookId, user,category]);


  //myVocaBookName props로 전달용
  const [myVocaBookName, setMyVocaBookName] = useState(''); // myVocaBookName 상태 추가
  useEffect(() => {
    if (data && data.length > 0) {
      setMyVocaBookName(data[0].myVocaBookName); // data가 있으면 첫 번째 요소의 myVocaBookName을 상태로 설정
    }
  }, [data]); // data가 변경될 때마다 실행

  useEffect(() => {
    if (data) {
      setStack([...data]);
      setCurrentVoca(data[0]);
      setTotal(data.length);
      setRemaining(data.length);
      setIsDataLoaded(true);
    }
  }, [data]);


  //제한시간 로직
  const [timeLeft, setTimeLeft] = useState(20); 
  const [variant, setVariant] = useState('info'); 

  //다음 퀴즈로 전환(진행)
  const nextVoca = () => {
    const newStack = [...stack];
    newStack.pop();
    setStack(newStack);
    setTimeLeft(20);
    setCurrentVoca(newStack[newStack.length - 1]);
    setRemaining(newStack.length);
    setVariant('info');
  };

    //제한시간에 따른 진행도bar
    useEffect(() => {
      if (((total - remaining) / total) * 100 === 100) {
        return;
      }
      const timerId = setInterval(() => {
        setTimeLeft((prevTimeLeft) => {
          if (prevTimeLeft <= 1) {
            clearInterval(timerId);
            return 0;
          } else {
            const newTimeLeft = prevTimeLeft - 1;
            if (newTimeLeft <= 5) {
              setVariant('danger');  
            }
            return newTimeLeft;
          }
        });
      }, 1000); 
    
      return () => {
        clearInterval(timerId);  
      };
    }, [timeLeft]);
    
    //제한시간이 다 될 경우
    useEffect(() => {
      if (timeLeft === 0) {
        dispatch(showPopup('제한시간이 다 됐습니다!'));
        nextVoca();
        setTimeLeft(20);
        setVariant('info');
      }
    }, [timeLeft]);

    if (loading && !data) return <CircleSpinner />;
    
    if (error) return (
      <MyVocaContainerBlock>
        <h3>오류!</h3>
        <h3>접근 불가능한 URL입니다.</h3>
      </MyVocaContainerBlock>
    );

    return(
      <MyVocaContainerBlock>
        <ProgressBarBlock>
          <ProgressBar animated now={((total - remaining) / total) * 100} />
        </ProgressBarBlock>
        <ProgressBarBlock>
          <ProgressBar animated variant={variant} now={(timeLeft / 20) * 100} />
        </ProgressBarBlock>
        <MyVoca 
          voca={currentVoca} 
          nextVoca={nextVoca} 
          stackSize={stackSize} 
          timeLeft={timeLeft} 
          category={category} 
          myVocaBookName={myVocaBookName}
          isDataLoaded={isDataLoaded}
        />
      </MyVocaContainerBlock>
    )
}

export default React.memo(MyVocaContainer);