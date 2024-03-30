import axios from "axios";

export async function getMyVocaBooksAPI({userId}){
  const response =  await axios.get(`/api/myvocabook/myVocaBookList/${userId}`);
  return response.data;
}
