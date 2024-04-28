package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import  static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Get_Example {

	@Test
	public void testRest() {
		
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getBody().asString());
		
		int actualStatus=response.getStatusCode();
		Assert.assertEquals(actualStatus, 200);
		
		}
	
	@Test
	public void testGet() {
		baseURI="https://reqres.in/api/users";
		//baseURI="https://reqres.in/api/users?page=2";
		
		//Implementing BDD
		given()
			.queryParam("page", 4)
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log();
			
		given()
		.when()
			.get()
		.then()
			.statusCode(200);
			//.log().all();
		
	}
	
	
	
}