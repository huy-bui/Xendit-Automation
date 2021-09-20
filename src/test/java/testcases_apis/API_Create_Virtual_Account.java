package testcases_apis;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.RequestBuilder;
import commons.Constants;
import io.restassured.response.Response;

public class API_Create_Virtual_Account {
	
	@Test
	public void Create_Virtual_Account_Test() {
		RequestBuilder requestBuilder = new RequestBuilder();
		String externalId = "demo_virtual_account";
		String bankCode = "BNI";
		String name = "Michael Huy";
		Response response = requestBuilder.postToCreateVirtualAccount(Constants.API_SECRET_KEY, 
				externalId, bankCode, name);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Status code returns: " + statusCode);
	}

}
