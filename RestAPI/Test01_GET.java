package RestAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Test01_GET {

//https://www.youtube.com/watch?v=JJ7Tp7_fX4c&list=PLhW3qG5bs-L8dDZPP1tpQldU4tzZdPfRv
//REST Assured API testing Beginner Tutorial | Part 1 - Getting Started
// https://automationstepbystep.com/
//https://rest-assured.io/
	
//	REST Assured is a Java library for testing RESTful web services
//	It is used to invoke REST web services and check response
//	Can be used to test XML as well as JSON based web services
//	It supports POST, GET, PUT, DELETE, OPTIONS, PATCH and HEAD requests and can be used to validate and verify the response of these requests
//	Can be integrated with testing frameworks like JUnit, TestNG etc
//	REST Assured is implemented in Groovy
//
//	Prerequisites
//	Java
//	IDE (Eclipse, IntelliJ, etc)
//	Maven
//	TestNG

	@Test
	void test_01() {
		
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("String: " + response.asString());
		System.out.println("getBody: " + response.getBody());
		System.out.println("getStatusCode: " + response.getStatusCode());
		System.out.println("getStatusLine: " + response.getStatusLine());
		System.out.println("getHeader: " + response.getHeader("content-type"));
		System.out.println("getTime: " + response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void test_02() {	
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)//201
		.body("data.id[0]", equalTo(7));
		; 
	}
	
	
	
	
	
}
