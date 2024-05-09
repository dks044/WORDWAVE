import axios from "axios";

// 환경 변수에서 API 기본 URL을 가져옵니다.
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

// Axios 인스턴스 생성
const api = axios.create({
  baseURL: API_BASE_URL,
});

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

//myVocaBook의 정보(업데이트폼 활용)
export async function getOneMyVocaBookAPI({myVocaBookId,userId}){
  const response = await axios.get(`/api/myvocabook/get/${myVocaBookId}/${userId}`)
  return response.data;
}

//MyVocaBook 삭제
export async function deleteMyVocaBookAPI({myVocaBookId}){
  const response = await axios.delete(`/api/myvocabook/delete/${myVocaBookId}`)
  return response.data;
}

//MyVocaBook 수정
export async function updateMyVocaBookAPI(name, myVocaBookId, userId, imageFile) {
  const formData = new FormData();
  formData.append('request', new Blob([JSON.stringify({name, myVocaBookId, userId})], {type: "application/json"}));
  if (imageFile) {
    formData.append('imageFile', imageFile);
  }

  return await axios.patch(`/api/myvocabook/patch/myVocaBook`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}

//MyVocaBook 검증(해당 사용자의 것이 맞는지)
export async function validateMyVocaBookAPI({myVocaBookId,userId}){
  const response = await axios.get(`/api/myvocabook/validate/${myVocaBookId}/${userId}`)
  return response.data;
}

//MyVoca 업로드 (나만의 단어 생성)
export async function createMyVocaAPI(myVocaBookId, userId,category,myVocas){
  const response = await axios.post(`/api/myvoca/create`,{myVocaBookId,userId,category,myVocas});
  return response.data;
}

//MyVcoa 업로드폼 데이터 (업로드폼에 표시될 데이터)
export async function updateFormMyVocaAPI({myVocaBookId,category}){
  const response = await axios.get(`/api/myvoca/updateForm/${myVocaBookId}/${category}`)
  return response.data;
}

//MyVoca 업데이트 (나만의 단어 수정)
export async function updateMyVocaAPI(myVocaBookId,userId,prevCategory,nextCategory,myVocas){
  const response = await axios.patch(`/api/myvoca/patch`,{myVocaBookId,userId,prevCategory,nextCategory,myVocas});
  return response.data;
}

//MyVoca 삭제 (나만의 단어 삭제)
export async function deleteMyVocaAPI({myVocaBookId,userId,category}){
  const response = await axios.delete(`/api/myvoca/delete/${myVocaBookId}/${userId}/${category}`);
  return response.data;
}

//나만의 단어 퀴즈
export async function selectMyVocaAPI({myVocaBookId,userId,category}){
  const response = await axios.get(`/api/myvoca/${myVocaBookId}/${userId}/${category}`);
  return response.data;
}