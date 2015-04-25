package hello;

//import org.json.simple.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application {

    public static void main(String args[])  {
    	String json = "{\"paramsArray\": [\"first\", 100],"
                + "\"paramsObj\": {\"one\": \"two\", \"three\": \"four\"},"
                + "\"paramsStr\": \"some string\"}";
    	String url="";
    	try {
			json=getContentOfHTTPPage("");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	System.out.println("json- "+json);

    JSONParser parser = new JSONParser();

    Object obj=null;
	try {
		obj = parser.parse(json);
	} catch (ParseException e) {
		System.out.println("error with parsing");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    JSONObject jsonObj = (JSONObject) obj;
    System.out.println(jsonObj);

    JSONArray ja = (JSONArray) jsonObj.get("routes");
    jsonObj=(JSONObject) ja.get(0);
    ja=(JSONArray) jsonObj.get("legs");
    jsonObj=(JSONObject) ja.get(0);
    jsonObj=(JSONObject) jsonObj.get("distance");
    System.out.println(jsonObj.get("value"));
    //jsonObj=(JSONObject) jsonObj.get("value");
    System.out.println(jsonObj);
    int dist = Integer.parseInt(jsonObj.get("value").toString());
    System.out.println("distance= "+dist);
    }
    public static String getContentOfHTTPPage(String pageAddress) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	URL pageURL = new URL("http://maps.googleapis.com/maps/api/directions/"
    			+ "json?origin=%D0%9A%D0%B8%D0%B5%D0%B2,%20%D0%9A%D1%80%D0%B5%D1%89%D0%B0%D1%82%D0%B8%D0%BA%201"
    			+ "&destination=%D0%9A%D0%B8%D0%B5%D0%B2,%20%D0%BF%D1%80%D0%BE%D1%81%D0%BF%D0%B5%D0%BA%D1%82%20%D0%BF%D0%BE%D0%B1%D0%B5%D0%B4%D1%8B%2022"
    			+ "&region=ua&sensor=false"); 
    	URLConnection uc = pageURL.openConnection();
    	BufferedReader br = new BufferedReader( new InputStreamReader( uc.getInputStream()));
    	try {
    		String inputLine; 
    		while ((inputLine = br.readLine()) != null) {
    			sb.append(inputLine); 
    		}
    		} 
    	finally { br.close(); } 
    	return sb.toString(); }

}