import  axios  from "axios";

const API_URL= "https://project-sql-ai.onrender.com/analyze";

export const analyzeQuery = async (query)=>{
    const response =await  axios.post(
        API_URL,{
            query: query
        }
    );
    return response.data;
}