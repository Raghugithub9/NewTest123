package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutExample {

	@Test
	public void putTest() {
		JSONObject json=new JSONObject();
		json.put("name","Prasad");
		json.put("role","Developer");

		baseURI="https://reqres.in/api/users/82";
		given()
			.header("Content-type","application/json")
			.contentType(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200);
		
		given()
			.header("Content-type","application/json")
			.contentType(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.put()
		.then()
			.log().all();
		
	}

	
}
