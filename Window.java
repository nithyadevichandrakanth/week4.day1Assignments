package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//h5[text()='Click and Confirm new Window Opens']/following-sibling::button"))
				.click();
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> newWindowHandle = new ArrayList<String>(windowHandle);
		driver.switchTo().window(newWindowHandle.get(1));
		String title = driver.getTitle();
		System.out.println(title);
		driver.switchTo().window(newWindowHandle.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> newWindowHandle1 = new ArrayList<String>(windowHandle1);
		driver.switchTo().window(newWindowHandle1.get(1));
		int size = newWindowHandle1.size();
		System.out.println(size);

	}

}
