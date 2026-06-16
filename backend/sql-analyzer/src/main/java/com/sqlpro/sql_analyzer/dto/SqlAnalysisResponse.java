package com.sqlpro.sql_analyzer.dto;

public class SqlAnalysisResponse {
    private String queryType;
    private String parsing;
    private String optimization;
    private String execution;
    private String resultGeneration;
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getParsing() {
		return parsing;
	}
	public void setParsing(String parsing) {
		this.parsing = parsing;
	}
	public String getOptimization() {
		return optimization;
	}
	public void setOptimization(String optimization) {
		this.optimization = optimization;
	}
	public String getExecution() {
		return execution;
	}
	public void setExecution(String execution) {
		this.execution = execution;
	}
	public String getResultGeneration() {
		return resultGeneration;
	}
	public void setResultGeneration(String resultGeneration) {
		this.resultGeneration = resultGeneration;
	}
    
}
