package pageUIs;

public class CallBacksPageUI {
	
	public static final String PRODUCT_ID = "//td[text()=\"%s\"]"; // product id
	public static final String CREATED_DATE_OF_PRODUCT = "//td[text()=\"%s\"]/preceding-sibling::td[contains(text(),\"%s\")]"; // product id & date time
	public static final String STATUS_OF_PRODUCT = "//td[text()=\"%s\"]/preceding-sibling::td/span[text()=\"Completed\"]"; // product id
}
