package Com.Banking.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageClass.TC_001_Banking_CustomerLoginPage;
import Com.Banking.PageClass.TC_002_Banking_AddCustomerPage;

public class TC_002_AddCustomer extends Banking_BaseClass {

    @Test(dataProvider = "getData")
    public void TC_002_Banking_AddCustomer(String firstName, String lastName, String postCode) {

        TC_001_Banking_CustomerLoginPage clp = new TC_001_Banking_CustomerLoginPage();
        clp.getbankManagerLogin();
        logger.info("Successfully Clicked On Bank Manager Login Button!");
        clp.getaddCustomer();
        logger.info("Successfully Clicked On Add Customer Button!");
        Assert.assertTrue(clp.getdetailsCustomer());
        logger.info("Successfully Launched To Fill Customers Details!");

        TC_002_Banking_AddCustomerPage acp = new TC_002_Banking_AddCustomerPage();
        acp.getfirstName(firstName);
        acp.getlastName(lastName);
        acp.getpostCode(postCode);
    }

    @DataProvider
    public Object[][] getData() {
        // Assuming 'excel' is an instance of ExcelReader class

        String sheetName = "AddCustomerTest";
        int rows = reader.getRowCount(sheetName);
        int cols = reader.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = reader.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }
}
