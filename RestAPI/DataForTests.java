package RestAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DataForTests {



	//@DataProvider(name = "DataForPost")
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

	@DataProvider(name = "DeleteData")
	public Object[] datForDelete() {
		
		return new Object [] {
				4,5,6,7	
		};
	}
	
	@Test(dataProvider = "DeleteData")
		public void test_delete(int userId) {
			
			baseURI ="http://localhost:3000/";
			
			when(). 
				delete("/users/" + userId). 
			then().
				statusCode(404);
		}
	
	
}





