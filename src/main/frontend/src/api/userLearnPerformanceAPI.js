import axios from "axios";

export async function createUserLearnPerformance({userId, category, learnType, answerCount, wrongCount}){
  const response = await axios.post('/api/userLearn/create_userLearnPerformance', {
    userId, 
    category, 
    learnType, 
    answerCount,
    wrongCount
  });
  return response.data;
}
