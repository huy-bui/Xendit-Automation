package testcases_UIs.Account;

import org.testng.Assert;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Constants;
import pageObjects.CallBacksPage;
import pageObjects.DeveloperPage;
import utils.ConvertUtils;

public class Generate_API_Secrect_Key_Test extends BaseTest{

	DeveloperPage developerPage;
	CallBacksPage callBacksPage;
	public String apiSecretKey;
	
	@Test
	public void Generate_Api_Key() {
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
	}
}
