package Com.Banking.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.Banking.BaseClass.Banking_BaseClass;

public class TC_001_Banking_CustomerLoginPage extends Banking_BaseClass {

	@FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
	public WebElement bankManagerLogin;

	@FindBy(xpath = "//div[@class='center']//button[contains(text(),'Add Customer')]")
	public WebElement addCustomer;

	@FindBy(xpath = "(//div[@class='ng-scope'])[3]")
	public WebElement detailsCustomerPage;

	public TC_001_Banking_CustomerLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void getbankManagerLogin() {
		bankManagerLogin.click();
	}

	public void getaddCustomer() {
		addCustomer.click();
	}

	public boolean getdetailsCustomer() {
		boolean customerdetails = detailsCustomerPage.isDisplayed();
		return customerdetails;
	}

}
