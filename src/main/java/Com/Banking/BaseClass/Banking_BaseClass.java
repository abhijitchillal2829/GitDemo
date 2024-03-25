package Com.Banking.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import Com.Banking.Configuration.Readconfiguration;
import Com.Banking.Utilities.ExcelReader;
import Com.Banking.Utilities.TestUtils;

public class Banking_BaseClass {

    Readconfiguration read = new Readconfiguration();
    String BaseURL = read.getApplicationURL();
    public static WebDriver driver;
    public static Logger logger;
    public ExcelReader reader;

    @Parameters("Browsername")
    @BeforeMethod
    public void initialization(String Browsername) {
        reader = new ExcelReader
                ("C:\\Users\\Ramesh\\eclipse-workspace\\Automation_DataDriven_Framework\\src\\main\\java\\Com\\Banking\\TestData\\TestData.xlsx");
        logger = Logger.getLogger("Banking Application");
        PropertyConfigurator
                .configure("C:\\Users\\Ramesh\\eclipse-workspace\\Automation_DataDriven_Framework\\log4j.properties");
        if (Browsername.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");
            driver = new ChromeDriver();
        } else if (Browsername.equals("FireFox")) {
            driver = new FirefoxDriver();
        } else if (Browsername.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (Browsername.equals("IE")) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGELOAD_TIMEOUT));
        driver.get(BaseURL);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    public String getScreenShot(String Testcasename) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Timestamp = Timestamp.replaceAll("[^a-zA-Z0-9]", "_");
        String Name = "-Screenshot-" + Timestamp;
        String destination = System.getProperty("user.dir") + "/Screenshot/" + Testcasename + "" + Name + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
}
