package testcases.Account;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.BaseTest;
import commons.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.CallBacksPage;
import pageObjects.DeveloperPage;

public class Create_Virtaul_Account_Test extends BaseTest {

	DeveloperPage developerPage;
	CallBacksPage callBacksPage;
	public String apiSecretKey;

	@Test
	public void Create_Virtual_Account() {
		homePage.clickSettingsTab();
		developerPage = homePage.clickAPIKeyLink();
		developerPage.clickGenerateSerectKeyButton();
		developerPage.inputApiKeyName("TestName123");
		developerPage.selectProductPermission(Constants.MONEY_IN_PRODUCT, Constants.WRITE);
		developerPage.selectProductPermission(Constants.MONEY_OUT_PRODUCT, Constants.WRITE);
		developerPage.selectProductPermission(Constants.xenPlatform, Constants.WRITE);
		developerPage.clickGenerateKeyButton();
		developerPage.inputPassword(Constants.PASSWORD);
		developerPage.clickConfirmButton();
		
		// Verify create API key success
		Assert.assertTrue(developerPage.isSuccessMessageDisplayed(), "Success message does NOT displayed!");
		
		// Get API Secret key
		apiSecretKey = developerPage.getSecretApiKey();
		developerPage.clickCloseButton();
		
		// Verify the API Secret Key displays in the list
		Assert.assertTrue(developerPage.isApiKeyDisplayedInList("TestName123"), "API secret key does NOT displayed!");
		
		// Send API to create virtual account
		RequestSpecification request = RestAssured.given()
				.baseUri("https://api.xendit.co")
				.auth().preemptive().basic(apiSecretKey, "")
				.contentType("application/x-www-form-urlencoded; charset=utf-8")
				.formParam("external_id", "demo_virtual_account_1475459775872")
				.formParam("bank_code", "BNI")
				.formParam("name", "Huy ABC");
		Response response = request.post("callback_virtual_accounts");
		int statusCode = response.statusCode();
		JsonPath body = response.jsonPath();
		
		Assert.assertEquals(statusCode, 200, "Send API failed, status code returns: " + statusCode);
		String productId = body.get("id");
		
		// Verify the virtual account in CallBacks screen
		callBacksPage = homePage.clickCallBacksTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(callBacksPage.isProductIdDisplayed(productId), "ProductID does NOT displayed");
		softAssert.assertTrue(callBacksPage.isCompletedStatusDisplayed(productId), "Complete status does NOT displayed");
		softAssert.assertAll();
		
	}
}
