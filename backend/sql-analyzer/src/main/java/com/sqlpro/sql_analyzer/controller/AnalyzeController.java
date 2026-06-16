package  com.sqlpro.sql_analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlpro.sql_analyzer.dto.AnalyzeRequest;
import com.sqlpro.sql_analyzer.dto.SqlAnalysisResponse;
import com.sqlpro.sql_analyzer.serivce.AnalysisService;
import com.sqlpro.sql_analyzer.serivce.GeminiService;
import com.sqlpro.sql_analyzer.validation.SqlValidationService;

@RestController
public class AnalyzeController {

	private final AnalysisService analysisService;
	private final GeminiService gemniService;
	private final SqlValidationService sqlValidationService;
	
	//constructor
	public AnalyzeController(AnalysisService analysisService, GeminiService gemniService,SqlValidationService sqlValidationService) {
		this.analysisService=analysisService;
		this.gemniService=gemniService;
		this.sqlValidationService=sqlValidationService;
	}


	@PostMapping("/analyze")
	 public SqlAnalysisResponse analyze(@RequestBody AnalyzeRequest request) {
		String query = request.getQuery();
		if(request.getQuery()==null || request.getQuery().trim().isEmpty()) {
			throw 	new IllegalArgumentException("SQL query cannot be null.");
		}
		if(request.getQuery().length()<10) {
			throw new RuntimeException("Please enter a valid SQL statement!");
		}	
		sqlValidationService.valiate(query);
			return analysisService.analyzeQuery(query);
	}
	
	
	
}
