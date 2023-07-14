package tests;

import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOneForRestAssure {
	@Test
	public void testDemo1() {


		Response response =get("https://reqres.in/api/users?page=2");
		System.out.println("Get Session id :" + response.getSessionId());
		System.out.println("Status code :" + response.getStatusCode());
		System.out.println("Time :" + response.getTime());
		System.out.println("Body :" + response.getBody().asString());
		System.out.println("Status Line :" + response.getStatusLine());
		System.out.println("Header :" + response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
	@Test
	public void testDemo2() {

		baseURI = "https://reqres.in/api";
		given().
		  get("/users?page=2").
		then().
		  statusCode(200).
		  body("data[1].id",equalTo(8)).log().all();
		  
	}
	

}
