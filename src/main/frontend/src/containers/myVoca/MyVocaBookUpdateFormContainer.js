import React, { useEffect } from "react";
import MyVocaBookUpdateForm from "../../components/myVoca/MyVocaBookUpdateForm";
import { useDispatch, useSelector } from "react-redux";
import { getMyVocaBookOne } from "../../modules/myVoca/myVocaBook";
import CircleSpinner from "../../components/CircleSpinner";

function MyVocaBookUpdateFormContainer({myVocaBookId}){
  const data = useSelector((state) => state.myVocaBook.myVocaBookOne.data);
  const loading = useSelector((state) => state.myVocaBook.myVocaBookOne.loading);
  const error = useSelector((state) => state.myVocaBook.myVocaBookOne.error);
  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getMyVocaBookOne({myVocaBookId}));
  },[dispatch,myVocaBookId])


  // // if (loading && !data) return <CircleSpinner />;
  // // if (error) return null;
   return(
    
    <p>ddd</p>
  )
}

export default MyVocaBookUpdateFormContainer;