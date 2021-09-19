package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import pageUIs.DeveloperPageUI;

public class DeveloperPage extends BasePage{

	public DeveloperPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickGenerateSerectKeyButton() {
//		moveToElement(DeveloperPageUI.GENERATE_SECRET_KEY_BUTTON);
		clickToElement(DeveloperPageUI.GENERATE_SECRET_KEY_BUTTON);
	}
	
	public void inputApiKeyName(String name) {
		sendKeysToElement(DeveloperPageUI.API_KEY_NAME_TEXTBOX, name);
	}
	
	public void selectProductPermission(String product, String permission) {
		String permissionElement = String.format(DeveloperPageUI.PRODUCTS_PERMISSION, product, permission);
		clickToElement(By.xpath(permissionElement));
	}
	
	public void clickGenerateKeyButton() {
		moveToElement(DeveloperPageUI.GENERATE_KEY_BUTTON);
		clickToElement(DeveloperPageUI.GENERATE_KEY_BUTTON);
	}
	
	public void inputPassword(String password) {
		sendKeysToElement(DeveloperPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickConfirmButton() {
		clickToElement(DeveloperPageUI.CONFIRM_BUTTON);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isSuccessMessageDisplayed() {
		return isElementDisplayed(DeveloperPageUI.SUCCESS_TEXT);
	}
	
	public String getSecretApiKey() {
		return getElementText(DeveloperPageUI.SECRET_API_KEY);
	}
	
	public void clickCloseButton() {
		clickToElement(DeveloperPageUI.CLOSE_BUTTON);
	}
	
	public boolean isApiKeyDisplayedInList(String apiKeyName) {
		String apiKeyNameElement = String.format(DeveloperPageUI.API_KEY_NAME_IN_LIST, apiKeyName);
		return isElementDisplayed(By.xpath(apiKeyNameElement));
	}
	
}
