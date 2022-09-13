package RestAPI;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//https://ecs.syr.edu/faculty/fawcett/Handouts/CSE681/code/CODEGEN_Products/calcWebService/Calc.asmx
//Go to Service Description
//https://ecs.syr.edu/faculty/fawcett/Handouts/CSE681/code/CODEGEN_Products/calcWebService/
public class Test07_Soap_XML_Request {

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
			statusCode(500).
			log().all();

		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

}
