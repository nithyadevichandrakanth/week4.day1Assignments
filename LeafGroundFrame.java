package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame = driver
				.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("Click")).click();
		//driver.switchTo().defaultContent();
		WebElement nestedFrame = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']"));
		driver.switchTo().frame(nestedFrame);
		driver.findElement(By.id("Click")).click();
		List<WebElement> countOfTotalFrame = driver.findElements(By.xpath("//iframe"));
		int size = countOfTotalFrame.size();
		System.out.println(size);
	}

}
