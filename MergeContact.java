package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> findContact = new ArrayList<String>(windowHandles);
		driver.switchTo().window(findContact.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[1]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> findContact1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(findContact1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> findContact3 = new ArrayList<String>(windowHandles3);
		driver.switchTo().window(findContact3.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td/div/a)[6]")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> findContact4 = new ArrayList<String>(windowHandles4);
		driver.switchTo().window(findContact4.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		if (title.contains("View")) {
			System.out.println(title);
		} else
			System.out.println(false);

	}

}
