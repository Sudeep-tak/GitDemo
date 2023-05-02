package org.rahulshettyacademy.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentsReport {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() 
	{
		// Create the reports folder if it doesn't exist
		String path = System.getProperty("user.dir") + "/reports/";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path+"extent.html");
		htmlReporter.config().setReportName("Web Automation Result");
		htmlReporter.config().setDocumentTitle("TestReports");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Sudeep Tak");
		
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test =extent.createTest("InitialDemo");
		System.setProperty("webdriver.chrome.driver","C://Users//sudee//OneDrive//Documents//ChromeBrowsers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("test do not match");
		extent.flush();
		driver.quit();
	}

}