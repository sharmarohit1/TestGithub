package apiGetRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC01_GetRequest {

	
	@Test
	 void getWeatherDetails() {
		
		// Specify Base URI
		
		
		String[][] strarr = {{"abc","got1"}, {"def","got2"},{"ghi","got3"},{"jkl","got4"}};
		
		System.out.println(strarr[0][1]);
		
		
		
		//RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city" ;
		RestAssured.baseURI = "https://reqres.in/" ;
		
		// Creating Request Object
		
		RequestSpecification httpRequest = RestAssured.given();
		
		String rstr = RandomStringUtils.randomNumeric(2);
		
		System.out.println(rstr);
		
		
		// Creating Response Object
		
	//	Response httpResponse = httpRequest.request(Method.GET, "/Hyderabad");
		Response httpResponse = httpRequest.request(Method.GET, "/api/users?page=2");
		
	// Checking Status Code
	
		JsonPath jsonpath = httpResponse.jsonPath();
		System.out.println("Value of id: " + jsonpath.getList("data.first_name"));

		int scode = httpResponse.getStatusCode();
		Assert.assertEquals(200, scode);
	    String sline = httpResponse.getStatusLine();
	    Assert.assertEquals("HTTP/1.1 200 OK", sline);
	    httpResponse.header("Content-Type");
	//	System.out.println(scode + "-----------------" + sline);
	    Headers allheader = httpResponse.headers();
	
	    for(Header shead: allheader) {
	    	System.out.println(shead.getName() + "----------------" + shead.getValue());	    	
	    }
	    
		
		
		
	}
	




}
