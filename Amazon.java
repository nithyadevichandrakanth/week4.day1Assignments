package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[4]"));
		String firstProductPrice = price.getText();
		System.out.println(firstProductPrice);
		/*
		 * for (int i = 0; i < price.size(); i++) { String priceAllItems =
		 * price.get(0).getText(); System.out.println(priceAllItems); }
		 */
		String rating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Number of rating of the first product " + rating);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> firstWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(firstWindow.get(1));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Snaps1/Screenshot.png");
		FileUtils.copyFile(source, Dest);
		driver.findElement(By.id("add-to-cart-button")).click();
		WebElement cartSubTotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]"));
		String Total = cartSubTotal.getText();
		System.out.println(Total);
		if(firstProductPrice.equals(Total))
		{
			System.out.println("Price verified"); 
		}
		else
		
			System.out.println("Price not verified"); 
		
		driver.quit();
	}

}
