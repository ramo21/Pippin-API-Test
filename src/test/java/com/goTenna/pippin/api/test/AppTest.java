package com.goTenna.pippin.api.test;

import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Unit test for API.
 * Dog API (https://dogapi.dog/) was used for this assignment
 * By Omar Pippin
 */
public class AppTest {
	private static final Logger logger = LogManager.getLogger(AppTest.class);
	final String baseURL = "https://dogapi.dog/api/v2/";
	public RequestSpecification httpRequest;

	@BeforeEach
	public void setUp() throws Exception {
		// set the base url so to call every time
		RestAssured.baseURI = baseURL;
	}

	@Test
	void test_getResponse_breeds() {
		httpRequest = RestAssured.given();

		Response response = RestAssured.get("breeds/");
		response.getStatusCode();

		// logger statements
		logger.info("");
		logger.info("******************************");
		logger.info("Get response for breeds");
		logger.info("Status code: {}", response.getStatusCode());
		logger.info("Response: {}", response.asString());
		logger.info("Time: {}", response.getTime());
		logger.info("******************************");
		logger.info("");

		// test
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(lessThan(5L), TimeUnit.SECONDS);
	}

	@Test
	void test_getIdResponse_breeds() {
		httpRequest = RestAssured.given();

		Response response = RestAssured.get("breeds/036feed0-da8a-42c9-ab9a-57449b530b13");
		response.getStatusCode();

		// logger statements
		logger.info("");
		logger.info("******************************");
		logger.info("Get response with ID for breeds");
		logger.info("Status code: {}", response.getStatusCode());
		logger.info("Response: {}", response.asString());
		logger.info("Time: {}", response.getTime());
		logger.info("******************************");
		logger.info("");

		// test
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(lessThan(5L), TimeUnit.SECONDS);
		response.then().assertThat().body("data.attributes.name", equalTo("Affenpinscher"));

	}

	@Test
	void test_getResponse_groups() {
		httpRequest = RestAssured.given();

		Response response = RestAssured.get("groups/");
		response.getStatusCode();

		// logger statements
		logger.info("");
		logger.info("******************************");
		logger.info("Get response for breeds");
		logger.info("Status code: {}", response.getStatusCode());
		logger.info("Response: {}", response.asString());
		logger.info("Time: {}", response.getTime());
		logger.info("******************************");
		logger.info("");

		// test
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(lessThan(5L), TimeUnit.SECONDS);
	}

	@Test
	void test_getIdResponse_groups() {
		httpRequest = RestAssured.given();

		Response response = RestAssured.get("groups/8000793f-a1ae-4ec4-8d55-ef83f1f644e5");
		response.getStatusCode();

		// logger statements
		logger.info("");
		logger.info("******************************");
		logger.info("Get response with ID for groups");
		logger.info("Status code: {}", response.getStatusCode());
		logger.info("Response: {}", response.asString());
		logger.info("Time: {}", response.getTime());
		logger.info("******************************");
		logger.info("");

		// test
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(lessThan(5L), TimeUnit.SECONDS);
		response.then().assertThat().body("data.attributes.name", equalTo("Foundation Stock Service"));

	}

	@Test
	void test_getResponse_facts() {
		httpRequest = RestAssured.given();

		Response response = RestAssured.get("facts/");
		response.getStatusCode();

		// logger statements
		logger.info("");
		logger.info("******************************");
		logger.info("Get response for facts");
		logger.info("Status code: {}", response.getStatusCode());
		logger.info("Response: {}", response.asString());
		logger.info("Time: {}", response.getTime());
		logger.info("******************************");
		logger.info("");

		// test
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(lessThan(5L), TimeUnit.SECONDS);
	}

}
