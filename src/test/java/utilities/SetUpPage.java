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

	public ExtentHtmlReporter htmlReport;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		header = new HeaderComponent();
		plp = new ProductListPage();
		login = new LoginPage();

		driver.get(TestingData.HomePageURL);
		System.out.println("This is before method from Setup page");
		lib.waitTime(3);

		htmlReport = new ExtentHtmlReporter("test-output/ExtentReport/testReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		test = report.createTest("123");
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

			String screenShot = lib.takeScreenShot(testName);

			test.log(Status.FAIL, MarkupHelper.createLabel(testName + "-Test Case failed", ExtentColor.ORANGE));
			test.fail(testResult.getThrowable());
			test.fail("Fail test case screenshot"+test.addScreenCaptureFromPath(screenShot));
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + "-Test Case passed", ExtentColor.BLUE));
		} else if (testResult.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + "-Test Case Skiped", ExtentColor.GREEN));
		}

	}

}
