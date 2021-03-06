package utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.HeaderComponent;
import pages.LoginPage;
import pages.ProductListPage;
import testData.TestingData;

public class SetUpPage {

	public WebDriver driver;
	public static UtilityLibrary lib;
	public ValidationClass validate;
	public HeaderComponent header;
	public ProductListPage plp;
	public LoginPage login;

	ExtentHtmlReporter htmlReport; // --> it will create html format
	public ExtentReports report; // --> it is actual report
	public ExtentTest test; // --> Representing the testmethod

	@BeforeTest
	public void beforeTest() {
		htmlReport = new ExtentHtmlReporter("test-output/ExtentReport/testReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
	}

	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		header = new HeaderComponent();
		plp = new ProductListPage();
		login = new LoginPage();

		driver.get(TestingData.HomePageURL);
		lib.waitTime(1);
	}

	@AfterMethod
	public void endTest(ITestResult testResult) throws IOException {

		loadReport(testResult);

		driver.quit();
	}

	@AfterTest
	public void finishTesting() {
		report.flush();
	}

	
	private void loadReport(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String testName = testResult.getName();
			String screenShotPath = lib.takeScreenShot(testName);

			test.log(Status.FAIL, MarkupHelper.createLabel(testName + " - Test Case failed", ExtentColor.RED));

			test.fail(testResult.getThrowable());
			test.fail("Failed test case screenshot" + test.addScreenCaptureFromPath(
					System.getProperty("user.dir")+"/"+screenShotPath));

		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Passed", ExtentColor.GREEN));

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Skiped", ExtentColor.GREY));
		}
	}

}
