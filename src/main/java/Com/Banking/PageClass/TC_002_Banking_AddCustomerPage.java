package Com.Banking.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.Banking.BaseClass.Banking_BaseClass;

public class TC_002_Banking_AddCustomerPage extends Banking_BaseClass{
	
	@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
	public WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder=\"Post Code\"]")
	public WebElement postCode;
	
	@FindBy(xpath = "(//button[contains(text(),\"Add Customer\")])[2]")
	public WebElement addCustomer;
	
	public TC_002_Banking_AddCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getfirstName(String fn) {
		firstName.sendKeys(fn);
		return fn;
	}
	
	public String getlastName(String ln) {
		lastName.sendKeys(ln);
		return ln;
	}
	
	public String getpostCode(String pc) {
		postCode.sendKeys(pc);
		return pc;
	}
	
	public void getaddCustomer() {
		addCustomer.click();
	}
	

}
