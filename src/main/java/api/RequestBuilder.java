package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	public Response postToCreateVirtualAccount(String apiKey, String externalId, String bankCode, String name) {
		// Send API to create virtual account
		RequestSpecification request = RestAssured.given()
				.baseUri("https://api.xendit.co")
				.auth().preemptive()
				.basic(apiKey, "")
				.contentType("application/x-www-form-urlencoded; charset=utf-8")
				.formParam("external_id", externalId)
				.formParam("bank_code", bankCode)
				.formParam("name", name);
		Response response = request.post("callback_virtual_accounts");
		return response;
	}

}
