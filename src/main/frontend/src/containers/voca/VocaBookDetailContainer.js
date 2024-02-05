import React, { useEffect } from "react";
import VocaBookDetailList from "../../components/voca/VocaBookDetailList";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { Spinner } from "react-bootstrap";
import { getVocaBookDetail } from "../../api/vocaAPI";
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
  const { data, loading, error } = useSelector(
    state => state.voca.vocabook[vocaBookId]
  ) || {
    loading: false,
    data: null,
    error: null
  }; // 아예 데이터가 존재하지 않을 때가 있으므로, 비구조화 할당이 오류나지 않도록

  const dispatch = useDispatch();

  useEffect(() => {
    if (data) return; // 포스트가 존재하면 아예 요청을 하지 않음
    dispatch(getVocaBookDetail(vocaBookId));
  }, [vocaBookId, dispatch, data]);

  if (loading) return (
    <SpinnerWrapper>
      <StyledSpinner animation="grow" variant="info" />
    </SpinnerWrapper>
  );
  if (error) return <div>에러 발생!</div>;
  if (!data) return null;

  return(
    <VocaBookDetailBlock>
      <VocaBookDetailList categories={data}/>
    </VocaBookDetailBlock>
  )
}





export default React.memo(VocaBookDetailContainer);