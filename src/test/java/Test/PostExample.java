package Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostExample {

	
	@Test
	public void postTest() {
		JSONObject json=new JSONObject();
		json.put("name","Raghu");
		json.put("role","Tester");

		baseURI="https://reqres.in/api/users";
		given()
			.header("Content-type","application/json")
			.contentType(ContentType.JSON)
			.body(json.toJSONString()).
		when()
			.post().
		then()
			.statusCode(201);
		
		//Log display
		given()
			.header("Content-type","application/json")
			.contentType(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.post()
		.then()
			.log().all();
		
	}
	
}
