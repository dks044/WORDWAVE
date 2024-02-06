import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getVocaBookList } from "../../modules/vocabook";
import styled from "styled-components";
import { Spinner } from "react-bootstrap";
import VocaBookListComponent from "../../components/voca/VocaBookListComponent";

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
const VocaBookListContainerBlock = styled.div`
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 10%;
`
const Title = styled.h1`
  text-align: center;
  font-weight: bold;
`

function VocaBookListContainer() {
  const { data, loading, error } = useSelector(state => state.vocabook.vocaBooks);
  const dispatch = useDispatch();

  useEffect(() => {
    if(data) return;
    dispatch(getVocaBookList());
  }, [data,dispatch]);

  if (loading) return (
    <SpinnerWrapper>
      <StyledSpinner animation="grow" variant="info" />
    </SpinnerWrapper>
  );
  if (error) return <div>에러 발생!</div>;
  
  console.log(data);



  return (
    <VocaBookListContainerBlock>
      <Title>VOCA</Title>
      <hr/>
      <VocaBookListComponent vocaBooks={data || []}/>
    </VocaBookListContainerBlock>
  )
};


export default React.memo(VocaBookListContainer);