package ResponseValidation;

import org.apache.http.Header;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseHeaderValidation {

	
	
	@Test
	public void test() {
RequestSpecification rs=RestAssured.given();

rs.baseUri("https://reqres.in");
rs.basePath("api/users?page=1");

Response res=rs.get();



System.out.println("Date Header value is "+res.getHeader("Date"));

String str=res.getStatusLine();


System.out.println("Status Line "+str);

System.out.println("********************************************************");

Headers header1=res.getHeaders();

for(io.restassured.http.Header hd:header1){
	System.out.println(hd.getName()+"    "+hd.getValue());
}


}
	}