import React, { useState } from "react";
import styled from "styled-components";

const QuizContainer = styled.div``;

const Quiz = styled.div``;

const GrammarQuiz = ({ grammarBook }) => {
  //TODO: QuizContainer안의 Quiz 정답 맞추면 다음 Quiz 보여주기
  return (
    <QuizContainer>
      {grammarBook.grammars.map((grammar) => (
        <Quiz key={grammar.id}>{grammar.sentence}</Quiz>
      ))}
    </QuizContainer>
  );
};

export default GrammarQuiz;
