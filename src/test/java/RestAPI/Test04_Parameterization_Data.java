package RestAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test04_Parameterization_Data extends DataForTests {

	//https://mockoon.com/
	//https://github.com/typicode/json-server
	
	// cmd json-server --watch db.json
	// C:\Users\Sean Jeong db.json
	
	//http://localhost:3000/
	//http://localhost:3000/users
	//http://localhost:3000/subjects/1/users
	//http://localhost:3000/subjects?name=Automation
	
	
//	How to run a test multiple times with different sets of data
//	How to provide data from the same class
//	How to provide data from different class
//	How to provide TestNg parameters
//
//	What is TestNG DataProvider
//	- Helps to write data driven tests
//	- Same test can be run multiple times with diff sets of data
//	- Annotation @DataProvider
//	- The annotated method is used to return object containing test data
//	- This test data can be used in actual tests

	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {
		
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Albert";
//		data[0][1] = "Einstein";
//		data[0][2] = 2;
//		
//		data[1][0] = "Thomas";
//		data[1][1] = "Edison";
//		data[1][2] = 1;
//		
//		return data;
		
		return new Object [][] {
			{"Graham","Bell", 1},
			{"Henry", "Ford", 2}	
		};	
	}
	
	@Test(dataProvider = "DataForPost")
	public void test_post(String firstName, String lastName, int subjectId) {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
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
	//@DataProvider(name = "DeleteData")
//	public Object[] datForDelete() {
//		
//		return new Object [] {
//				4,5,6,7	
//		};
//	}
	
	//@Test(dataProvider = "DeleteData")
		public void test_delete(int userId) {
			
			baseURI ="http://localhost:3000/";
			
			when(). 
				delete("/users/" + userId). 
			then().
				statusCode(404);
		}
		@Parameters("userId")
		@Test
		public void test_delete2(int userId) {
			
			System.out.println("Value for userId is : " +userId);
			baseURI ="http://localhost:3000/";;
			
			when(). 
				delete("/users/" + userId). 
			then().
				statusCode(404);
		}
	
}





