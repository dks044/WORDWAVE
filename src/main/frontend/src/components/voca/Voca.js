import React, { useEffect, useState } from "react";
import { Button, Form, InputGroup, ProgressBar } from "react-bootstrap";
import styled from "styled-components";

const HidenEngWord = styled.h1`
  font-weight: bolder;
`

function Voca({ voca,nextVoca }) {
  if (!voca) return null;

  return (
    <div>
      {/* 영어부터 제시하는 퀴즈일 경우 */}
      {voca.quizStatus === 1 && 
      <>
        <HidenEngWord>{voca.hiddenEngWord}</HidenEngWord>
        <h5>{voca.korWord}</h5>
        <hr />
        <Form.Floating className="mb-3">
          <Form.Control
            id="floatingInputCustom"
            type="email"
            placeholder="답안 입력하기"
          />
          <label htmlFor="floatingInputCustom">답안 입력</label>
          <div className="d-grid gap-2">
            <Button variant="primary" size="lg">
              정답제출하기
            </Button>
          </div>
        </Form.Floating>
        <input type="hidden" value={voca.engWord}/>
      </>
      }
    </div>
  );
}

export default React.memo(Voca);
