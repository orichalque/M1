package JSONParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONObject {
	String json;
	
	public JSONObject(String s) {
		json = s;
		json = json.replace("\"", "");
		json = json.replace("{", "");
		json = json.replace("}", "");
	}
	
	public Object getValue(String identifier) {
		String regex = "("+identifier+"(.*,))|(,("+identifier+"):.*$)";
		System.out.println(regex);
		String jsonResult = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher result;
		result = pattern.matcher(json);
		while (result.find()) {
			jsonResult = result.group();
			jsonResult = jsonResult.replace(",", "");
			jsonResult = jsonResult.replace(identifier+":", "");
			System.out.println(jsonResult);
		}
		return null;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
