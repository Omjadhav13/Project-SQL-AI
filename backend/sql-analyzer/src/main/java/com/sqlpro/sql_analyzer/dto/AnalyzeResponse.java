package com.sqlpro.sql_analyzer.dto;

public class AnalyzeResponse {
	
	private String analysis;
	
	public AnalyzeResponse(String analysis) {
		this.analysis=analysis;
	}
	
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis=analysis;
	}

}
