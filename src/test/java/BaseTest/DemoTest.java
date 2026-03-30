package BaseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.Driver;

public class DemoTest extends Driver {

	@Test
	public void test() {

		By cancel = By.cssSelector("img[alt='cross']");
		By departureDate = By.xpath("//div[@aria-label='Departure Date inputbox']");
//		By calendarMonthLocator = By.xpath("//div[@aria-label='Departure Date inputbox']");
		By calendarMonthLocator2 = By.xpath("//div[@class='react-datepicker__month-container']");
		By dateLocator = By.xpath(".//div[contains(@class,'react-datepicker__day')]");
		By priceLocator = By.xpath(".//span[contains(@class,'custom-day-content') ] ");

//		driver.findElement(cancel).click();
//		WebElement departureDateButton = driver.findElement(departureDate);

		waitForAElementToBeClickable(cancel).click();
		WebElement departureDateButton = waitForAElementToBeClickable(departureDate);
		departureDateButton.click();

		List<WebElement> calendarMonthsList = waitForAElementsToBeVisible(calendarMonthLocator2);
		WebElement JanCalWebElement = calendarMonthsList.get(0);
		List<WebElement> JanPriceList = JanCalWebElement.findElements(priceLocator);

		int lowestPrice = Integer.MAX_VALUE;
		WebElement priceEle = null;
		for (WebElement price : JanPriceList) {
//			System.out.println(prices.getText());
			String priceString = price.getText();
			if (priceString.length() > 0) {
				String priceString1 = priceString.replace("₹", "").replace(",", "");
//			System.out.println(price);

				int priceInt = Integer.parseInt(priceString1);
				if (priceInt < lowestPrice) {
					lowestPrice = priceInt;
					priceEle = price;
				}
			}
		}

		System.out.println("Lowest Price: " + lowestPrice);
		WebElement dateEle=priceEle.findElement(By.xpath(".//..//.."));
		System.out.println(dateEle.getAttribute("aria-label"));
	

	}
	
//	public static WebElement selectTheMonthfromCalander(int inex) {
//		waitForAElementToBeClickable(cancel).click();
//		WebElement departureDateButton = waitForAElementToBeClickable(departureDate);
//		departureDateButton.click();
//
//		List<WebElement> calendarMonthsList = waitForAElementsToBeVisible(calendarMonthLocator2);
//		WebElement JanCalWebElement = calendarMonthsList.get(inex);
//		return JanCalWebElement; 
//	}

}
