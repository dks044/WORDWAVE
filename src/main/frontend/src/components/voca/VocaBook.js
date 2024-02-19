import React, { useState, useRef } from "react";
import { Button, Overlay, Popover } from "react-bootstrap";
import styled from "styled-components";

const Title = styled.h1`
  font-weight: bold;
  text-align: center;
`;

function VocaBook({ vocaBook }) {
  const [show, setShow] = useState({});
  const [target, setTarget] = useState(null);
  const ref = useRef(null);

  const handleClick = (event, index) => {
    setShow((prevShow) => ({ ...prevShow, [index]: !prevShow[index] }));
    setTarget(event.target);
  };

  if (!vocaBook) return null; 
  return (
    <>
      <Title>{vocaBook.name}</Title>
      <hr />
      <div ref={ref}>
        {vocaBook.categories && vocaBook.categories.map((category, index) => (
          <div key={index} style={{ width: '100%' }}>
            <Button
              variant="outline-primary"
              size="lg"
              style={{ marginBottom: "20px", width: '100%' }}
              onMouseOver={(event) => handleClick(event, index)}
              onMouseOut={(event) => handleClick(event, index)}
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
                  <strong>Holy guacamole!</strong> Check this info.
                </Popover.Body>
              </Popover>
            </Overlay>
          </div>
        ))}
      </div>
    </>
  );
}

export default React.memo(VocaBook);
