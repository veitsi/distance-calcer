package hello;

//import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application {

    public static void main(String args[])  {
    	String json = "{\"paramsArray\": [\"first\", 100],"
                + "\"paramsObj\": {\"one\": \"two\", \"three\": \"four\"},"
                + "\"paramsStr\": \"some string\"}";
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
    System.out.println(jsonObj.get("paramsArray"));
    // some string

//    JsonObject jo = jsonObj.get("paramsObj");
//    System.out.println(jo.get("three"));
//    // four
//
//    JsonArray ja = jsonObj.get("paramsArray");
//    System.out.println(ja.get(1));
//    // 100


    }

}