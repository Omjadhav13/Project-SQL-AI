package com.sqlpro.sql_analyzer.serivce;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqlpro.sql_analyzer.dto.SqlAnalysisResponse;
@Service
public class AnalysisService {
	private final GeminiService geminiService;
    
	public AnalysisService(GeminiService geminiService) {
        this.geminiService = geminiService;
    }
	
	public SqlAnalysisResponse analyzeQuery(String query) {
		 try {
		        String aiResponse = geminiService.generateExplanation(query);

		        ObjectMapper mapper = new ObjectMapper();

		        return mapper.readValue(aiResponse, SqlAnalysisResponse.class);

		    } catch (Exception e) {
		        throw new RuntimeException("Failed to parse AI response", e);
		    }
	}
//	public String analyzeQuery(String query) {
//		query = query.toUpperCase();
//		if (query.startsWith("SELECT")) {
//			return " This is a SELECT query used to retrieve data from a table.";
//		}
//		if (query.startsWith("INSERT")) {
//			return "This is an INSERT query used to add data into a table.";
//		}
//		if (query.startsWith("UPDATE")) {
//			return "This is an UPDATE query used to modify existing data.";
//		}
//		if (query.startsWith("DELETE")) {
//			return "This is a DELETE query used to remove data.";
//		}
//
//		return "Unable to identify query type.";
//	}
	

}
