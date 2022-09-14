package RestAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class Test06_Validate_JSON_Schema {
	// https://www.liquid-technologies.com/online-json-to-schema-converter
	// https://reqres.in/
	// https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator/5.2.0
	// https://github.com/rest-assured/rest-assured/wiki/Usage
	
	//C:\Users\Sean Jeong\eclipse-workspace\RestAPI\target\classes

	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";

		given().get("users?page=2")
			.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200);
	}

}
