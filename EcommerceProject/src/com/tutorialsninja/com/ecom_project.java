package com.tutorialsninja.com;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class ecom_project {

	public static void main(String[] args) throws InterruptedException, IOException {

		String month_year = "December 2022";

		Date currentDate = new Date();

		String fileName = currentDate.toString().replace(" ", "-").replace(":", "-");

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_tutorial\\EcommerceProject\\WebDriver\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[text()='Phones & PDAs']")).click();
		driver.findElement(By.linkText("HTC Touch HD")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//ul[@class='thumbnails']/li[1]")).click();
		Thread.sleep(2000);

		WebElement nextButton = driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']"));

		for (int i = 0; i < 2; i++) {
			nextButton.click();
			Thread.sleep(2000);
		}

		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(".//screenshot//" + fileName + " .png"));

		driver.findElement(By.xpath("//button[@title='Close (Esc)']")).click();
		Thread.sleep(1000);

		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.click();
		Thread.sleep(1000);
		quantity.clear();
		Thread.sleep(1000);
		quantity.sendKeys("2");
		Thread.sleep(1000);

		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(1000);
		// System.out.println(driver.findElement(By.tagName("Success: You have added
		// ")).getText());

		WebElement laptop = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(laptop).perform();

		driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='HP LP3065']")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,250)");

		driver.findElement(By.xpath("//i[@class=\"fa fa-calendar\"]")).click();
		Thread.sleep(1000);

		while (true) {
			String text = driver.findElement(By.xpath("//th[@class=\"picker-switch\"]")).getText();
			if (text.equals(month_year)) {
				break;
			} else {

				driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
			}
		}

		driver.findElement(By.xpath("//td[text()=\'31\']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cart-total")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@class='text-right']/a[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='guest']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("button-account")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Step 2: Billing Details ']"));
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.click();
		Thread.sleep(1000);
		firstName.sendKeys("test-name");
		
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.click();
		Thread.sleep(1000);
		lastName.sendKeys("demo-name");
		
		WebElement Email = driver.findElement(By.id("input-payment-email"));
		Email.click();
		Thread.sleep(1000);
		Email.sendKeys("demo@gmail.com");
		
		WebElement Telephone = driver.findElement(By.name("telephone"));
		Telephone.click();
		Thread.sleep(1000);
		Telephone.sendKeys("0123456789");
		
		WebElement Address = driver.findElement(By.name("address_1"));
		Address.click();
		Thread.sleep(1000);
		Address.sendKeys("6050,First");
		
		WebElement City = driver.findElement(By.name("city"));
		City.click();
		Thread.sleep(1000);
		City.sendKeys("Demand");
		
		WebElement postCode = driver.findElement(By.name("postcode"));
		postCode.click();
		Thread.sleep(1000);
		postCode.sendKeys("00121212");
		
		WebElement country = driver.findElement(By.id("input-payment-country"));
		Select select = new Select(country);
		select.selectByIndex(6);
		
		WebElement state = driver.findElement(By.id("input-payment-zone"));
		Select select1 = new Select(state);
		select1.selectByVisibleText("La Massana");
		Thread.sleep(2000);
		
		driver.findElement(By.id("button-guest")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(2000);
		
		WebElement finalPrice = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tfoot/tr[3]/td[2]"));
		System.out.println("The Final Price is: " + "\n" + finalPrice.getText());
		Thread.sleep(1000);
		
		driver.findElement(By.id("button-confirm")).click();
		Thread.sleep(1000);
		
		WebElement successfulMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		System.out.println(successfulMessage.getText());
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		
		driver.close();
	}

}
