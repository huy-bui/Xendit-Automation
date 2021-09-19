package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import pageUIs.CallBacksPageUI;

public class CallBacksPage extends BasePage{

	public CallBacksPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductIdDisplayed(String productId) {
		String productIdElement = String.format(CallBacksPageUI.PRODUCT_ID, productId);
		moveToElement(By.xpath(productIdElement));
		return isElementDisplayed(By.xpath(productIdElement));
	}
	
	public boolean isProductCreatedDateDisplayed(String productId, String dateTime) {
		String createdDateElement = String.format(CallBacksPageUI.CREATED_DATE_OF_PRODUCT, productId, dateTime);
		return isElementDisplayed(By.xpath(createdDateElement));
	}
	
	public boolean isCompletedStatusDisplayed(String productId) {
		String completedStatusElement = String.format(CallBacksPageUI.STATUS_OF_PRODUCT, productId);
		return isElementDisplayed(By.xpath(completedStatusElement));
	}
}
