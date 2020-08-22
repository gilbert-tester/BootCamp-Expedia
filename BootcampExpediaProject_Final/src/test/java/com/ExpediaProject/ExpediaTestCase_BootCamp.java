package com.ExpediaProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.fail;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ExpediaTestCase_BootCamp {
	WebDriver driver;
	WebDriverWait wait;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void beforeTest() {
		

		System.setProperty("webdriver.chrome.driver", "/Volumes/George/Selenium Browser Drivers/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	@Test
	public void flightBook() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.get("https://www.expedia.com");
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();
		driver.findElement(By.id("location-field-leg1-origin")).sendKeys("Los Angeles (QLA - All Airports)");
		Thread.sleep(3000);
		driver.findElements(By.xpath("//*[@data-stid='location-field-leg1-origin-result-item']")).get(1).click();
		Thread.sleep(3000);

		WebElement destination = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
		destination.click();
		driver.findElement(By.cssSelector("input#location-field-leg1-destination")).sendKeys("JFK - John F. Kennedy Intl.");
		Thread.sleep(3000);
		driver.findElements(By.xpath("//*[@data-stid='location-field-leg1-destination-result-item']")).get(1).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("2 travelers")).click();
		driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/section/div[1]/div[1]/div/button[1]")).click();


		driver.findElement(By.cssSelector("#adaptive-menu > div > div > div.uitk-scrim.guestsDoneBtn.fade-button > button"))
		.click();

		driver.findElement(By.xpath("//button[@data-testid='submit-button']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[@type='button'])[33]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[37]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[33]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[35]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("forcedChoiceNoThanks")).click();

		driver.get("https://www.expedia.com/Flight-Information?offerToken=v5-sos-835d07fcb2e047568d8b0c0b8cc40c2d-18-33-1~2.S~AQoCCAESBwjUBBABGAEgByABIAwgDSAJKAJSBNj0AQBYAnAA~AQpUCigIwYIBEgM2MDQYrpsBIO-5ASiRotYBMNai1gE4QkAAWAFqBUJBU0lDCigIwYIBEgQxMzg4GO-5ASCpUSiFo9YBMK-l1gE4QkABWAFqBUJBU0lDClIKJgjBggESAzI1MBipUSCMAijSrNYBMJ-u1gE4QkAAWAFqBUJBU0lDCigIwYIBEgQxMDYxGIwCIIu4ASi6r9YBMO2x1gE4QkABWAFqBUJBU0lDEgoIARABGAEqAkFBGAEiBAgBEAEoAigDKAQwAQ&originalPrice=296.20&currency=USD&adults=1&seniors=0&infantInLap=true&childAges=&trip=RoundTrip&cabinClass=coach&travelStartDate=2020-09-03&travelEndDate=2020-09-04&nonstopOnly=false&refundableFlightsOnly=false&legs[0].departureAirport=LAX&legs[0].arrivalAirport=JFK&legs[0].departureDate=2020-09-03&legs[1].departureAirport=JFK&legs[1].arrivalAirport=LAX&legs[1].departureDate=2020-09-04&rfrr=&superlativeMessages[0]=CP&superlativeMessages[1]=CP&udpDisplayMode=showhotelbanneronly");
		driver.findElement(By.id("bookButton")).click();

		WebElement drop = driver.findElement(By.id("sortDropdown"));

		Select s = new Select(drop);
		s.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-omniture-rfrr='FLT.SR.Filter.FareOptions.0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[data-omniture-rfrr='FLT.SR.Filter.Stops.0")).click();
		Thread.sleep(3000);



		driver.findElements(By.xpath("//button[@data-test-id='select-button']")).get(0).click();
		Thread.sleep(6000);
		driver.findElements(By.xpath("//*[contains(@data-test-id,'select-button-')]")).get(0).click();
		Thread.sleep(6000);
		driver.findElements(By.xpath("//*[@data-test-id='select-button']")).get(0).click();
		Thread.sleep(6000);
		driver.findElements(By.xpath("//*[@data-test-id='select-button-1']")).get(0).click();
		Thread.sleep(6000);

		WebElement alert = driver.findElement(By.cssSelector("a#forcedChoiceNoThanks"));
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(alert));
		alert.click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iter = ids.iterator();
		iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());

		Thread.sleep(6000);
		driver.findElement(By.id("bookButton")).click();


		driver.findElement(By.id("firstname[0]")).sendKeys("Modon");
		driver.findElement(By.cssSelector("[data-tealeaf-name='middleName']")).sendKeys("Kumar");
		driver.findElement(By.id("lastname[0]")).sendKeys("Uddin");

		Select se = new Select(driver.findElement(By.xpath("//*[@aria-label='Country/Territory Code']")));
		se.selectByValue("1");
		Thread.sleep(6000);

		driver.findElement(By.id("phone-number[0]")).sendKeys("9092324565");
		driver.findElement(By.id("confirmation-sms-provider-checkbox")).click();
		driver.findElement(By.id("gender_male[0]")).click();
		Thread.sleep(6000);
		Select month = new Select(driver.findElement(By.id("date_of_birth_month0")));
		month.selectByIndex(11);
		Select day = new Select(driver.findElement(By.id("date_of_birth_day[0]")));
		day.selectByIndex(23);
		Select year = new Select(driver.findElement(By.id("date_of_birth_year[0]")));
		year.selectByValue("1956");

		driver.findElement(By.cssSelector("input[name='creditCards[0].cardholder_name']")).sendKeys("Modon Kumar");
		driver.findElement(By.id("creditCardInput")).sendKeys("4147202443478112");
		Select expireMonth = new Select(driver.findElement(By.xpath("//*[@name='creditCards[0].expiration_month']")));
		expireMonth.selectByIndex(10);
		Select expireYear = new Select(driver.findElement(By.cssSelector("[name='creditCards[0].expiration_year']")));
		expireYear.selectByValue("2021");

		driver.findElement(By.id("new_cc_security_code")).sendKeys("987");

		Select billingCountry = (Select) driver.findElement(By.xpath("//*[@name='creditCards[0].country']"));
		billingCountry.selectByValue("USA");
		driver.findElement(By.xpath("//*[@name='creditCards[0].street']")).sendKeys("24321 Loma Linda");
		driver.findElement(By.xpath("//*[@name='creditCards[0].city']")).sendKeys("Loma Linda");
		Select state = new Select(driver.findElement(By.cssSelector("[required name='creditCards[0].state']")));
		state.selectByValue("CA");
		driver.findElement(By.xpath("//*[@name='creditCards[0].zipcode']")).sendKeys("92734");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("modon@uddin.com");
		driver.findElement(By.id("complete-booking")).click();


	}



	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
