import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { Spinner } from "react-bootstrap";
import VocaBookDetail from "../../components/voca/VocaBookDetail";
import voca, { getVocaBookDetailById } from "../../modules/vocabook";
import IsNotData from "../../components/IsNotData";
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
const VocaBookDetailBlock = styled.div`
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 10%;
`
function VocaBookDetailContainer({vocaBookId}){
  const { data, loading, error } = useSelector(state => state.voca.vocaBookCategory[vocaBookId])
  || {
    loading: false,
    data: null,
    error: null
  };
  const {vocaBookCategory} = useSelector(state=>state.vocabook.vocaBookCategory);
  console.log(vocaBookCategory)
  const dispatch = useDispatch();


  useEffect(() => {
    if (data) return;
    dispatch(getVocaBookDetailById(vocaBookId));
  }, [vocaBookId, dispatch, data]);

  if (loading) return (
    <SpinnerWrapper>
      <StyledSpinner animation="grow" variant="info" />
    </SpinnerWrapper>
  );
  if (error) return <div>에러 발생!</div>;
  if (!data) return (
    <IsNotData />
  )

  return(
    <VocaBookDetailBlock>
      <VocaBookDetail category={data} />
    </VocaBookDetailBlock>
  )
}





export default React.memo(VocaBookDetailContainer);