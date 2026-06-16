package com.sqlpro.sql_analyzer.serivce;

import org.springframework.stereotype.Service;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.Client;
import com.sqlpro.sql_analyzer.config.GeminiConfig;

@Service
public class GeminiService {
	private final GeminiConfig geminiConfig;

	public GeminiService(GeminiConfig geminiConfig) {
		this.geminiConfig = geminiConfig;
	}

	public String generateExplanation(String sqlQuery) {

		Client client = Client.builder().apiKey(geminiConfig.getApiKey()).build();

		String prompt = """
				You are a senior database engine expert.

				Analyze the SQL statement below.

				SQL:
				%s

				Important rules:

				1. Determine the PRIMARY statement type.
				Examples:
				- SELECT
				- INSERT
				- UPDATE
				- DELETE
				- CREATE TABLE
				- CREATE VIEW
				- CREATE PROCEDURE
				- CREATE FUNCTION
				- CREATE TRIGGER
				- ALTER TABLE
				- DROP TABLE

				2. If a procedure contains SELECT statements, the queryType is still CREATE PROCEDURE.

				3. Return ONLY valid JSON.

				Format:

				{
				  "queryType":"",
				  "parsing":"",
				  "optimization":"",
				  "execution":"",
				  "resultGeneration":""
				}

				Keep each field under 50 words.
				No markdown.
				No code blocks.
				No additional text.
				""".formatted(sqlQuery);
		GenerateContentResponse response = client.models.generateContent("gemini-2.5-flash", prompt, null);

		return response.text();
	}

}
