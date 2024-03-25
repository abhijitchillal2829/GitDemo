package Com.Banking.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String Name = "ExtentReport - " + Timestamp;
		String path = System.getProperty("user.dir") + "/Reports/" + Name + " " + ".html";
		
		ExtentHtmlReporter report = new ExtentHtmlReporter(path);
		report.config().setReportName("Automation Extent Report");
		report.config().setDocumentTitle("Automation Excution Report");
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Automation Test Engineer", "Abhijit Chillal");
		extent.setSystemInfo("Suite Name", "Regression");
		
		return extent;
	}
	
	

}
