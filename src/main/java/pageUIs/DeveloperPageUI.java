package pageUIs;

import org.openqa.selenium.By;

public class DeveloperPageUI {
	
	// API Keys
	public static final By GENERATE_SECRET_KEY_BUTTON = By.xpath("//button[text()=\"Generate secret key\"]/div");
	public static final By API_KEY_NAME_TEXTBOX = By.xpath("//input[@name=\"apiKeyName\"]");
	public static String PRODUCTS_PERMISSION = "//p[text()=\"%s\"]/following-sibling::div/button[text()=\"%s\"]";
	public static final By GENERATE_KEY_BUTTON = By.xpath("//button[text()=\"Generate key\"]");
	public static final By PASSWORD_TEXTBOX = By.xpath("//input[@type=\"password\"]");
	public static final By CONFIRM_BUTTON = By.xpath("//button[text()=\"Confirm\"]");
	public static final By SUCCESS_TEXT = By.xpath("//p[text()=\"Secret API key successfully created.\"]");
	public static final By SECRET_API_KEY = By.xpath("//span[@class=\"secret-api-key-success\"]");
	public static final By CLOSE_BUTTON = By.xpath("//button[text()=\"Close\"]");
	public static final String API_KEY_NAME_IN_LIST = "//tbody/tr/td[text()=\"%s\"]";
	public static final String EDIT_API_KEY = "//td[text()=\"%s\"]/following-sibling::td//div/img[@src=\"/images/icons/icon_edit_grey.svg\"]";
	public static final By APPLY_CHANGE_BUTTON = By.xpath("\"//div[@class=\\\"modal-footer\\\"]/button[text()=\\\"Apply changes\\\"]");
	public static final By OKAY_BUTTON = By.xpath("//button[text()=\"Okay\"]");
	public static final String API_PERMISSION = "//td[text()=\"%s\"]/following-sibling::td/p[1]";
}
