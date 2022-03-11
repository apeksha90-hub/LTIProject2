package apitest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RestAssuredTest {

	@Test
	public void TC1(){
		//Rest assured test case
		//declared based url of an appl
		RestAssured.baseURI="https://reqres.in/";
		//create a request to fetch user details
		Response response=RestAssured.given().get("api/users?page=2");
		System.out.println(response.asString());
		
		//validate response details -> response  body contains michael
		Assert.assertTrue(response.asString().contains("michael"));
		Assert.assertEquals(200, response.getStatusCode());
		//validate wheather response time within 10sec
		Assert.assertEquals(1, response.getTimeIn(TimeUnit.SECONDS));
		//fetch time seconds to get the response
		System.out.println(response.getTime());
		
		//fetch header of response
		Headers header=response.getHeaders();
		System.out.println(header);
		
	}
	@Test
	public void TC2() {
		//rest assured in BDD style
		RestAssured.given()
		      .baseUri("https://reqres.in/")
		      .when()
		           .get("api/users?page=2")
		       .then()
		           .statusCode(200);
	}
}
