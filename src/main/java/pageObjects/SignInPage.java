package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import pageUIs.SignInPageUI;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void inputEmail(String email) {
//		waitForElementVisible(SignInPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(SignInPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPassword(String password) {
		sendKeysToElement(SignInPageUI.PASSWORD_TEXT_BOX, password);
	}
	
	public void clickSignInButton() {
		clickToElement(SignInPageUI.SIGNIN_BUTTON);
		
	}
	
	public HomePage signIn(String email, String password) {
		inputEmail(email);
		inputPassword(password);
		clickSignInButton();
		return new HomePage(driver);
	}

}
