package week4.day2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MergeContact {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();  
		
		ChromeDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Enter Username
		WebElement element = driver.findElement(By.id("username"));
		element.sendKeys("Demosalesmanager");
		
		//Enter Password
		WebElement passwordElement = driver.findElement(By.name("PASSWORD"));
		passwordElement.sendKeys("crmsfa");
		
		//Click Login Button
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		
		//Click on CRM/SFA link
		WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaElement.click();
		
		//Click on Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//Handle the new window
		Set<String> set = driver.getWindowHandles();
		List<String> list= new ArrayList<>(set);
		driver.switchTo().window(list.get(1));
		
		// Click on First Resulting Contact
		driver.findElement(By.xpath("//a[text()='12297']")).click();
		
		//Come back to base window
		driver.switchTo().window(list.get(0));
		
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		//Handle the new window
		Set<String> set1 = driver.getWindowHandles();
		List<String> list1= new ArrayList<>(set1);
		driver.switchTo().window(list1.get(1));
		
		// Click on First Resulting Contact
		driver.findElement(By.xpath("//a[text()='12299']")).click();
		
		//Come back to base window
		driver.switchTo().window(list1.get(0));
		
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println("Current Title of the page is :" + title);
		
		
		
	}

}
