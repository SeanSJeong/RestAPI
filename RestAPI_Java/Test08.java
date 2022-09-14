package RestAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//https://ecs.syr.edu/faculty/fawcett/Handouts/CSE681/code/CODEGEN_Products/calcWebService/Calc.asmx
//Go to Service Description
//File C:\Users\Sean Jeong\eclipse-workspace\RestAPI\Soap\Add.xml

//https://www.youtube.com/watch?v=WvALfJRQjWE&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=12
public class Test08 {

	@Test
	public void validateSoapXML() throws IOException {
		try {

			File file = new File("./Soap/Add.xml");

			if (file.exists()) {
				System.out.println("  >> File exists");
			}

			FileInputStream fileInputStream = new FileInputStream(file);
			String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

			baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/CSE681/code/CODEGEN_Products/calcWebService/";

			given().
				contentType("text/xml").
				accept(ContentType.XML).
				body(requestBody);
			when().
				post("/Calc.asmx"). // 16:45
			then().
			statusCode(500). //200
			log().all();

		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

}
