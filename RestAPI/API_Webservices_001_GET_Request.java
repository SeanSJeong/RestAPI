package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Webservices_001_GET_Request {

	// Weather API - Validate status code & Status line

	@Test
	void getweatherDetails() {
		// Specify base URI
		RestAssured.baseURI = "https://weather.com/weather/city";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/SaltLakeCity");

		// print response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line is:" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}