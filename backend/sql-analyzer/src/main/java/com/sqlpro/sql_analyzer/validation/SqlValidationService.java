package com.sqlpro.sql_analyzer.validation;

import org.springframework.stereotype.Service;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;

@Service
public class SqlValidationService {
	public void valiate(String sql) {
		try {
			CCJSqlParserUtil.parse(sql);
		}
		catch(Exception e) {
			throw new RuntimeException( "Invalid SQL syntax. Please check your query and try again.");
		}
	}
}
