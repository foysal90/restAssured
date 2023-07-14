package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

import static org.hamcrest.Matchers.*;

public class soapXmlRequest {
	@Test
public void validateSoapXml() throws IOException{
		
		File f = new File("./soapRequest/soapAdd.xml");
		//checking if file exits or not
		if (f.exists()) {
			System.out.println("File exits and proceed to next steps");
			
		
		FileInputStream fis = new FileInputStream(f);
		
		String addBody = IOUtils.toString(fis, "UTF-8");
		
	
		RestAssured.baseURI = "http://www.dneonline.com"; 
		RestAssured.given().
		contentType("text/xml")
		.accept(ContentType.XML)
		.body(addBody)
		.when()
		.post("/calculator.asmx")
		.then()
		.statusCode(200)
		.log().all()
		.and()
		//validating 
		.body("//*:AddResult.text()", equalTo("15"));
		
		//XML schema validation part
//		.and()
//		.assertThat()
//		.body(RestAssuredMatchers.matchesXsdInClasspath("calculator.xsd"));
	}

	}}
