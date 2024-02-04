import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getVocaBookList } from "../modules/voca";
import styled from "styled-components";
import { Spinner } from "react-bootstrap";
import VocaBookComponent from "../components/VocaBookComponent";

const Loading = styled.div`
  
`
const SpinnerWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
`;
const StyledSpinner = styled(Spinner)`
  position: absolute;
  top: 30%;
  width: 200px;
  height: 200px;
  & .spinner-border {
    width: 100%;
    height: 100%;
  }
`;

function VocaBookListContainer(){
  const { data, loading, error } = useSelector(state => state.voca.vocabooks);
  const dispatch = useDispatch();
  useEffect(() => {
    if (data) return;  
    dispatch(getVocaBookList());
  }, [data, dispatch]);
  console.log(data);

  if(loading) return(
    <SpinnerWrapper>
      <StyledSpinner animation="grow" variant="info" />
    </SpinnerWrapper>
  )
  if(error) return <div>에러 발생!</div>;
  return(
    <>
      
    </>
  )
}

export default React.memo(VocaBookListContainer);