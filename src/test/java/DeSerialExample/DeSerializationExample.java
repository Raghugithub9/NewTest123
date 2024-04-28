package DeSerialExample;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class DeSerializationExample {


	@Test
	public void createUser()
	{
		//https://reqres.in/api/users
		//create Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		
		//create request body
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Raghu");
		jsonData.put("job", "QA");
		
		
		//perform post request
		Response response = requestSpec.
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		post();
		
		ResponseBody responseBody = response.getBody();
		
		//Deserialize json resoponse body to class object
		
		
				
		JSONDataTest res = responseBody.as(JSONDataTest.class);
		
		Assert.assertEquals(res.name, "Raghu");
		Assert.assertEquals(res.job, "QA");

		
	}
}
