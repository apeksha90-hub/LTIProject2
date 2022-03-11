package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PassingParam {

	@Test
	public void f() {
		
		RestAssured.given()
		.pathParam("pageNo",2) //passing parameter
		.baseUri("https://reqres.in/api/users?page=2") 
		.when()
		   .get("api/users?page={pageNo}")
		.then()
		   .statusCode(404)
		   .log().body();
	}
	
}

