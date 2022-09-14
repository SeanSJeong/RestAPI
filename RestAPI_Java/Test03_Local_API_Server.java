package RestAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test03_Local_API_Server {

	//https://mockoon.com/
	//https://github.com/typicode/json-server
	
	// cmd json-server --watch db.json
	// C:\Users\Sean Jeong db.json
	
	//http://localhost:3000/
	//http://localhost:3000/users
	//http://localhost:3000/subjects/1/users
	//http://localhost:3000/subjects?name=Automation
	
	//@Test
	public void test_get() {
		
		baseURI ="http://localhost:3000/";
		
		given(). 
		    param("name", "Automation").
			get("/subjects"). 
		then()
			.statusCode(200).
			log().all();
	}
	
	@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Tom");
		request.put("lastNmae", "Cooper");
		request.put("subjectId", 1);
		
		baseURI ="http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			post("/users"). 
		then().
			statusCode(201).
			log().all(); //200  
	}
	//@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastNmae", "Shephered");
		
		baseURI ="http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			patch("/users/4"). 
		then().
			statusCode(200).
			log().all(); //200  
	}
	//@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Mary");
		request.put("lastNmae", "Jane");
		request.put("subjectId", 1);
		
		baseURI ="http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			put("/users/4"). 
		then().
			statusCode(200).
			log().all(); //200  
	}
	
	
	//@Test
	public void test_delete() {
		
		baseURI ="http://localhost:3000/";
		
		when(). 
			delete("/users/4"). 
		then().
			statusCode(404);
	}
	
}
