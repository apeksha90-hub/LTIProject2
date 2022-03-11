package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {

	@Test
	public void f() {
		RestAssured.given()
		
		.baseUri("https://reqres.in/api/users?page=2") 
		.when()
		   .delete("/api/users/2")
		.then()
		   .statusCode(204);
		   
	}
	
}
