package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteExample {

	
	@Test
	public void deleteTest() {
		
		baseURI="https://reqres.in/api/users/2";
		given()
		.when()
			.delete()
		.then()
			.statusCode(204)
			.log().all();
		
		/*
		given()
		.when()
			.delete()
		.then()
			.log().all();
			*/
			}
}
