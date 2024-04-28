package ResponseValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationTypes {


	@Test
	public void BasicAuth()
	{
		RequestSpecification requestSpec = RestAssured.given();

		//Specify URL
		//requestSpec.baseUri("http://postman-echo.com");
		//requestSpec.basePath("/basic-auth");

		requestSpec.baseUri("https://httpbin.org");
		requestSpec.basePath("/basic-auth/raghu/raghu");
		
		//perform get request - non preemptive
		//Credentials won't be shared with Server initial, only if errror then credentials will be shared
		//Response response = requestSpec.auth().basic("raghu", "raghu").get();
		
		
		//perform get request - preemptive - credentials will be shared initially
		Response response = requestSpec.auth().preemptive().basic("raghu", "raghu").get();

		//print status line
		System.out.println("Responsne status:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());

	}

	@Test
	public void DigestAuth()
	{
		
		RequestSpecification requestSpec = RestAssured.given();

		//Specify URL
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/raghava/raghava");
		
		//perform get request
		//Response response = requestSpec.get();
		Response response = requestSpec.auth().digest("raghava", "raghava").get();

		Assert.assertEquals(response.statusCode()/*actual*/, 200,"check for status code");
		//print status line
		System.out.println("Digest Auth Responsne status:" + response.statusLine());
		System.out.println("Digest Auth Response body:" + response.body().asString());

	}

	@Test
	public void BearerToken()
	{
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Prasad1");
		payload.put("gender", "male");
		payload.put("email", "raghu.test121@gmail.com");
		payload.put("status", "active");
		
		
		String AuthToken = "Bearer b11579f91073f384aac01fe8142a1a76291f49980c1adf8c8036aeb949e3cee5";
	
		requestSpec.headers("Authorization", AuthToken)
					.contentType(ContentType.JSON)
					.body(payload.toJSONString());
		
		//perform post request
		Response response = requestSpec.post();
		

		//validate status code 
		Assert.assertEquals(response.statusCode()/*actual*/, 201/*expected*/,"check for status code");
	
		//print status line & response boy
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
		
		
	}
	
}


