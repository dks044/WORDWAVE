import React from "react";
import { Button } from "react-bootstrap";

export default function VocaBookDetail({category}){
  return (
    <div className="d-grid gap-2">
      <Button variant="info" size="lg">
        {category}
      </Button>
    </div>
  )
}

