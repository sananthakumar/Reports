package Reportgeneration.Reports;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	ExtentReports ext;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("RESULTS");
		
		
		//EXtenrtReports class is responsible for exporting results
		
		 ext=new ExtentReports();
		ext.attachReporter(reporter);
		ext.setSystemInfo("Tester" , "Ananth");
	}
	
	@Test
	public void url_check() {
		ext.createTest("url_check");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91999\\Downloads\\Selenium_learning\\chromedriver.exe");
		//Creating webdriver
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ultimatix.net/uxportal/uxportalhome.html/Megamenu");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close(); 
		ext.flush();
	}
	
	@Test
	public void url_check_1() {
		ExtentTest test=ext.createTest("url_check_1");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91999\\Downloads\\Selenium_learning\\chromedriver.exe");
		//Creating webdriver
		WebDriver driver=new ChromeDriver();
		driver.get("//www.facebook.com");
		System.out.println(driver.getTitle());
		test.fail("testing failed");
		driver.close(); 
		ext.flush();
	}
}
