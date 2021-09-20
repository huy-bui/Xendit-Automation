package testcases_UIs.Account;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import api.RequestBuilder;
import commons.BaseTest;
import commons.Constants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pageObjects.CallBacksPage;
import pageObjects.DeveloperPage;
import utils.ConvertUtils;

public class Create_Virtaul_Account_E2ETest extends BaseTest {

	DeveloperPage developerPage;
	CallBacksPage callBacksPage;
	public String apiSecretKey;

	@Test
	public void Create_Virtual_Account() {
		homePage.clickSettingsTab();
		developerPage = homePage.clickAPIKeyLink();
		developerPage.clickGenerateSerectKeyButton();
		String apiKeyName = String.valueOf(ConvertUtils.getEpochMilisecond());
		developerPage.inputApiKeyName(apiKeyName);
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
		Assert.assertTrue(developerPage.isApiKeyDisplayedInList(apiKeyName), "API secret key does NOT displayed!");
		
		// Send API to create virtual account
		RequestBuilder requestBuilder = new RequestBuilder();
		String externalId = "demo_virtual_account";
		String bankCode = "BNI";
		String name = "Michael Huy";
		Response response = requestBuilder.postToCreateVirtualAccount(apiSecretKey, externalId, bankCode, name);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Status code returns: " + statusCode);
		JsonPath body = response.jsonPath();
		String productId = body.get("id");
		
		// Verify the virtual account in CallBacks screen
		callBacksPage = homePage.clickCallBacksTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(callBacksPage.isProductIdDisplayed(productId), "ProductID does NOT displayed");
		softAssert.assertTrue(callBacksPage.isCompletedStatusDisplayed(productId), "Complete status does NOT displayed");
		softAssert.assertAll();
		
	}
}
