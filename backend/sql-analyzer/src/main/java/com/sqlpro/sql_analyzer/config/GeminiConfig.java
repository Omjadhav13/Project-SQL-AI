package com.sqlpro.sql_analyzer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.spi.ConfiguratorRank;

@Configuration
public class GeminiConfig {

	@Value("${gemini.api.key}")
	private String apiKey;
	
	public String getApiKey()
	{
		return apiKey;
	}
}
