package Base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Driver {

	protected WebDriver driver;
	private ChromeOptions options;
	protected WebDriverWait wait;

	private WebDriver getDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.addArguments("--disable-notifications");
//			options.addArguments("--disable-popup-blocking");
//			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("..........");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	@BeforeMethod
	protected void invokeBrowser() {
		driver = getDriver("chrome");
		driver.get("https://www.yatra.com/");

	}

//	@AfterMethod
	protected void tearDown() {
		driver.quit();
	}

	public WebElement waitForAElementToBeClickable(By e) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(e));
	}

	public List<WebElement> waitForAElementsToBeVisible(By e) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(e));
	}
}
