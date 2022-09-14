package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// https://www.youtube.com/watch?v=mkIliGAePBM&list=PLhW3qG5bs-L8dDZPP1tpQldU4tzZdPfRv&index=2
public class Test02_POST {
	
	//@Test
	public void test_1_post() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Sean"); //  "\"name\""
//		map.put("job", "Teacher");
		
//		System.out.println(map);
		
		JSONObject request = new JSONObject (); //map
		
		request.put("name", "Sean");
		request.put("job", "Teacher");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "application").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			post("https://reqres.in/api/users"). 
		then().
			statusCode(201); //200   // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
			

	}
	//@Test
	public void test_2_put() {

		JSONObject request = new JSONObject (); //map
		
		request.put("name", "Sean");
		request.put("job", "Teacher");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "application").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			put("https://reqres.in/api/users/2"). 
		then().
			statusCode(200).log().all(); //200  		
	}
	//@Test
	public void test_3_patch() {

		JSONObject request = new JSONObject (); //map
		
		request.put("name", "Sean");
		request.put("job", "Teacher");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "application").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			patch("https://reqres.in/api/users/2"). 
		then().
			statusCode(200)
			.log().all(); //200   		
	}
	@Test
	public void test_4_delete() {

		JSONObject request = new JSONObject (); //map
		
		request.put("name", "Sean");
		request.put("job", "Teacher");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "application").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when(). 
			delete("https://reqres.in/api/users/2"). 
		then().
			statusCode(204)
			.log().all(); //200   		
	}
}
