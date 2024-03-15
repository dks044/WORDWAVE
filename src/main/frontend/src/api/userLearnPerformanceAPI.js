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
