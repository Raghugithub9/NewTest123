package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestRestAPI {

	@Test
	public void testRest() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		int code=response.getStatusCode();
		Assert.assertEquals(code, 200);		
	}
	@Test
	public void test() {

RequestSpecification rs=RestAssured.given();
rs.baseUri("https://reqres.in");
rs.basePath("api/users?page=2");

Response res=rs.get();

ResponseBody resbody=res.getBody();
System.out.println(resbody.jsonPath());
	}
}