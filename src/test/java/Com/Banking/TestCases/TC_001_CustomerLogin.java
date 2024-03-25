package Com.Banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageClass.TC_001_Banking_CustomerLoginPage;

public class TC_001_CustomerLogin extends Banking_BaseClass{

	@Test
	public void TC_001_Banking_CustomerLogin() throws IOException, InterruptedException {
		
		TC_001_Banking_CustomerLoginPage clp = new TC_001_Banking_CustomerLoginPage();
		Thread.sleep(3000);
		clp.getbankManagerLogin();
		logger.info("Successfully Clicked On Bank Manager Login Button!");
		clp.getaddCustomer();
		logger.info("Successfully Clicked On Add Customer Button!");
		Assert.assertTrue(clp.getdetailsCustomer());
		logger.info("Successfully Launched To Fill Customers Details!");
	}
}
