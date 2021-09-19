package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSettingsTab() {
		clickToElement(HomePageUI.SETTINGS_TAB);
	}

	public DeveloperPage clickAPIKeyLink() {
		moveToElement(HomePageUI.API_KEYS_LINK);
		clickToElement(HomePageUI.API_KEYS_LINK);
		return new DeveloperPage(driver);
	}
	
	public CallBacksPage clickCallBacksTab() {
		clickToElement(HomePageUI.CALLBACKS_TAB);
		return new CallBacksPage(driver);
	}
}
