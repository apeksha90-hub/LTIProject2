package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
 @Test
 public void f() {
	//base url
	//request
	//body - JSON
	 String a = "{\n" + 
		  		"    \"name\": \"morpheus\",\n" + 
		  		"    \"job\": \"leader\"\n" + 
		  		"}";
	 
	 RestAssured.given()
        .contentType(ContentType.JSON)
        .body(a)
	    .when()
	         .post("https://reqres.in/api/users?page=2")
	    .then()
	         .statusCode(201)
	         .log().body();
   }
}
