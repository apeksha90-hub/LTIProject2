package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AthenRequest {

		@Test
		public void f() {
			RestAssured.given()
			.auth()
			.basic("postman","password") 
			.when()
			   .get("https://postman-echo.com/basic-auth\"")
			.then()
			   .log().body();
			   
		}
}
