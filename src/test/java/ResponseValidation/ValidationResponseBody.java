package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidationResponseBody {

	@Test
	public void UserListResponseBody()
	{
		//Get RequestSpecifction Reference
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base URI & base path
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=1");
		
		//create/perform get request
		Response response = requestSpec.get();
		
		//read response body
		ResponseBody responseBody =  response.getBody();
		
		String responseString = responseBody.asString();
		
		//print response body
		System.out.println("Response body:" + responseString);
		
		
		JsonPath jsonPathView  = responseBody.jsonPath();
		
		//x.data[4].first_name
		String lastName = jsonPathView.get("data[0].last_name");
		
		System.out.println("email address:"+ jsonPathView.get("data[1].avatar"));
	
		
		Assert.assertEquals(lastName,"Bluth","Check for presense of lastname as Bluth");
	
		
		
		
		

		
	}
}
