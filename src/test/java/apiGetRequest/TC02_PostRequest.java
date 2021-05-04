package apiGetRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_PostRequest {

	
	@Test
	void register() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject param = new JSONObject();
		
		param.put("email", "eve.holt@reqres.in");
		param.put("password", "pistol");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(param.toJSONString());
		
		Response httpResponse = httpRequest.request(Method.POST, "/api/register");
		
		// Checking body content
		
		JsonPath jsonpath = httpResponse.jsonPath();
		System.out.println("json values" + jsonpath.get("total"));
		
		
		
		
		
//		String body = httpResponse.getBody().asString();
//		System.out.println("Body Content is " + body);
//		
//		int scode = httpResponse.getStatusCode();
//		System.out.println("Status code is" + scode);
//		
//		String sline = httpResponse.getStatusLine();
//		System.out.println("Status line is " + sline);
//		
//		String jspath = httpResponse.jsonPath().get("token");
//		System.out.println("Success Code is: " + jspath);
			
	}}
