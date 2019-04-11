package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPITests {

	@Test
	public void checkSometing() {
		// https://restapi.demoqa.com/utilities/weather/city/hyderabad
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification request = RestAssured.given();

		Response response = request.request(Method.GET, "/Hyderabad");

		int statusCode = response.statusCode();
		System.out.println(statusCode);

		String statusLine = response.getStatusLine();
		System.out.println(statusLine);

		String responceBody = response.getBody().asString();
		System.out.println(responceBody);

		Assert.assertEquals(statusCode, 200);

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test
	public void register() {

		// https://restapi.demoqa.com/customer/register
		RestAssured.baseURI = "https://restapi.demoqa.com/customer";

		RequestSpecification request = RestAssured.given();

		// Add the parameters to the Json object
		//Its like has map 'Key' 'Value' pair
		JSONObject params = new JSONObject();
		params.put("FirstName", "muttu");
		params.put("LastName", "muttu");
		params.put("UserName", "muttu4");
		params.put("Password", "muttu123");
		params.put("Email", "muttu4@gmail.com");

		// Add header stating the request body ia a JSON
		request.headers("Content-Type", "application/json");

		// Add Json params to the body of the request
		request.body(params.toJSONString());

		// Post the request and check the response
		Response response = request.post("/register");

		System.out.println(response.body().asString());

		// Get the status code from the response
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, 201);

		// Get the success code form the response
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

		// Get the success Message from the response
		String successMessage = response.jsonPath().get("Message");
		Assert.assertEquals(successMessage, "Operation completed successfully");

	}
}
