package com.TPWebNCloud;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONObject {
	String json;
	public JSONObject(String s) {
		json = s;
		json = json.replace("{", "");
		json = json.replace("}", "");
		
	}
	
	public String getValue(String identifier) {
		String regex = "\""+identifier+"\""+":(\"){0,1}[\\w]+(\"){0,1}";
		String jsonResult = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher result; 
		result = pattern.matcher(json);
		while (result.find()) {
			jsonResult = result.group();
			jsonResult = jsonResult.replace("\""+identifier+"\"", "");
			jsonResult = jsonResult.replace("\"", "");
			jsonResult = jsonResult.replace(":", "");
		}
		return jsonResult;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
