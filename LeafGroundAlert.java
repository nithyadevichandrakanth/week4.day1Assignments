package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement Alert = driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']//following::span"));
		Alert.click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		WebElement text = driver.findElement(By.id("simple_result"));
		String simpleAlertText = text.getText();
		System.out.println(simpleAlertText);
		
		WebElement Alert1 = driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']//following::span"));
		Alert1.click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.accept();
		WebElement text1 = driver.findElement(By.id("result"));
		String ConfirmAlertText = text1.getText();
		System.out.println(ConfirmAlertText);
		
		WebElement Alert2 = driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']//following::span"));
		Alert2.click();
		Alert confirmAlert2 = driver.switchTo().alert();
		confirmAlert2.dismiss();
		WebElement text2 = driver.findElement(By.id("result"));
		String ConfirmAlertText1 = text2.getText();
		System.out.println(ConfirmAlertText1);
		
		WebElement Alert3 = driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']//following::span"));
		Alert3.click();
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		WebElement Alert4 = driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']//following::span"));
		Alert4.click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Nithya");
		String promptText = promptAlert.getText();
		System.out.println(promptText);
		promptAlert.accept();
		WebElement message = driver.findElement(By.id("confirm_result"));
		String promptMessage = message.getText();
		System.out.println(promptMessage);
		if(promptMessage.equals(promptText))
		{
			System.out.println(true);
		}
		else
			System.out.println(false);
		
		WebElement Alert5 = driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']//following::span"));
		Alert5.click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		
		driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']//following::span")).click();
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-newwin']")).click();
		
	}

}
