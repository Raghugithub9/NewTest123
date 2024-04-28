package ResponseValidation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ResponseTest {

	@Test
	public void test() {
baseURI="https://reqres.in/api/users/1";
RequestSpecification req=given();

Response response=req.get();
System.out.println(response.statusCode());

System.out.println(response.getBody().asString());
String str=response.getStatusLine();
System.out.println(str);

	}
	
	@Test
	public void testresponse() {
baseURI="https://reqres.in/api/users/2";
RequestSpecification req=given();

Response response=req.get();
ValidatableResponse valres=response.then();

//Assertions
valres.statusCode(200);
valres.statusLine("HTTP/1.1 200 OK");


	}
	
	@Test
	public void testresponse1() {
	
	given()
	.when()
		.get("https://reqres.in/api/users/2")
	.then()
		.statusLine("HTTP/1.1 200 OK")
		.statusCode(200);
	


	}
	
}