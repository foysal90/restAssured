package tests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class GetPostRestAssured {
	
	@Test
	public void getTest() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name",equalTo("George")).
		and().
		body("data.first_name", hasItems("George", "Rachel")).log().all();
	}
	
	
	@Test
	public  static void postTest() {
		
		Map<String, Object> post = new HashMap<String, Object>();
//		post.put("name", "aisha");
		
		JSONObject req = new JSONObject(post);
		req.put("name", "Ayeza");
		req.put("age", 1);

		System.out.println(req.toJSONString());
		baseURI = "http://localhost:3000";
		given().
		
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		 log().all();
		
		
	}
	

	@Test
	public  static void putTest() {
		

		
		JSONObject res = new JSONObject();
		res.put("firstname", "Foysal");
		res.put("age", 33);

		System.out.println(res.toJSONString());
		baseURI = "http://localhost:3000";
		given().
		
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().
		patch("/users/1").
		then().
		statusCode(200).
		 log().all();
		
		
	}
	
	
	
	
	
	
	
	

}
