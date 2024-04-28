package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PayPallGetAccessToekn {

	public String accessToken;
	@Test
	public void GetAccessToken()
	{
		
		String clientId = "AQjbOYUOFCqAVkftquouQn7KP1rRRpmp2_2RMYp2W8_hXqGjwTRA2iuly11yMjWaYdEUrv_J6WhbKr9Y";
		String clientSecret = "EMe81AJ9dVdQq8Jx23vNaqvyuKEdHgkptX9kqiBbdxbl-gJ8ulbiquBiT9s4lbc5exR-AKTCCNbWKRiV";
		
		//create request Specification 
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL
		requestSpec.baseUri("https://api-m.sandbox.paypal.com");
		requestSpec.basePath("/v1/oauth2/token");
		
		//Basic authorization
		Response response = requestSpec.auth().preemptive().basic(clientId, clientSecret).param("grant_type", "client_credentials").post();
		
		//To print response
		response.prettyPrint();
		
		
		//print status code & status line
		System.out.println("Response code:" + response.statusCode() );
		System.out.println("status line:" + response.statusLine() );
		
		
		Assert.assertEquals(response.statusCode(), 200,"check for response code");
		
		//get access token from response body.
		
		accessToken= response.getBody().path("access_token");
		
		System.out.println("access token:" + accessToken);
		
	}
	
	@Test(dependsOnMethods ="GetAccessToken")
	public void ListInvoice()
	{
		
		Response res= RestAssured.given().auth().oauth2(accessToken)
				.queryParam("page", "3")
				.queryParam("page_size", "4")
				.queryParam("total_count_required", "true")
					.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		System.out.println("*************Next Line*******************");
		
		//res.prettyPrint();
		//print status code & status line
				System.out.println("Response code:" + res.statusCode() );
				System.out.println("status line:" + res.statusLine() );
		
				//validate repsonse code
				Assert.assertEquals(res.statusCode(), 200,"check for response code");
				
		
	}
	
}
