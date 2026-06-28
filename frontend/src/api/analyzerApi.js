import  axios  from "axios";

const API_URL= "http://localhost:8080/analyze";

export const analyzeQuery = async (query)=>{
    const response =await  axios.post(
        API_URL,{
            query: query
        }
    );
    return response.data;
}