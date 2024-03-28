import axios from "axios";

export async function createUserLearnPerformanceAPI({userId, category, learnType, answerCount, wrongCount}){
  const response = await axios.post('/api/userLearn/create_userLearnPerformance', {
    userId, 
    category, 
    learnType, 
    answerCount,
    wrongCount
  });
  return response.data;
}

export async function getUserLearnHistoryAPI({ category, userId }) {
  const response = await axios.get(`/api/userLearn/get_userLearnHistory?category=${category}&userId=${userId}`);
  return response.data;
}

//사용자의 연속학습일 조회
export async function getUserCLDAPI() {
  const response = await axios.get('/api/auth/select_consecutiveLearningDays');
  return response.data;
}

export async function getAllUserLearnPerformanceAPI({userId,pageNum}){
  const response = await axios.get(`/api/userLearn/get_allUserLearnPerformance?userId=${userId}&pageNum=${pageNum}`);
  return response.data;
}