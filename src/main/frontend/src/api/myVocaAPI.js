import axios from "axios";

export async function getMyVocaBooksAPI({userId}){
  const response =  await axios.get(`/api/myvocabook/myVocaBookList/${userId}`);
  return response.data;
}

export async function createMyVocaBookAPI(name, userId, imageFile) {
  // FormData 객체 생성
  const formData = new FormData();
  // 필드 
  formData.append('request', new Blob([JSON.stringify({name, userId})], {type: "application/json"}));
  formData.append('imageFile', imageFile);

  // axios 요청 시 FormData 객체와 적절한 Content-Type 설정으로 전송
  return await axios.post(`/api/myvocabook/create`, formData, {
      headers: {
          'Content-Type': 'multipart/form-data'
      }
  });
}

// myVocaBook의 디테일(카테고리들)을 가져오는 API
export async function getMyVocaBookAPI({myVocaBookId,userId}){
  const response = await axios.get(`/api/myvocabook/${myVocaBookId}/${userId}`)
  return response.data;
}

//myVocaBook의 정보
export async function getOneMyVocaBookAPI({myVocaBookId}){
  const response = await axios.get(`/api/myvocabook/get/${myVocaBookId}`)
  return response.data;
}

//MyVocaBook 삭제
export async function deleteMyVocaBookAPI({myVocaBookId}){
  const response = await axios.delete(`/api/myvocabook/delete/${myVocaBookId}`)
  return response.data;
}