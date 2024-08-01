package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	// for Reporting
	@BeforeTest
	public void beforeTestMethod() {
		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "RHEL8");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "root");
		spark.config().setDocumentTitle("Automation report ");
		// Name of the report
		spark.config().setReportName("Automation Test Result (by Vishakha) ");
		// Dark Theme
		spark.config().setTheme(Theme.STANDARD);
	}

	//
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.get(Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + "- Test Case Failed", ExtentColor.RED));

		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.ORANGE));
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.GREEN));
		}

		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}

	public void setupDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Wrong Browser!!!");
		}
	}
}
