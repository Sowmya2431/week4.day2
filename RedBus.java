package week4.day2;
import java.time.Duration;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//Launch the url https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		Thread.sleep(2000);
		
		//Enter From -Madiwala Bangalore
		WebElement from = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
		from.sendKeys("Madiwala Bangalore");
		Thread.sleep(20000);
		
		//Handle the Alert
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		
		
		//Enter To Koyambedu Chennai
		WebElement to = driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']"));
		to.sendKeys("Koyambedu Chennai");
		Thread.sleep(20000);
		
		//Select the Date 10-Jun-2022
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.tagName("table"));
		driver.findElement(By.xpath("//td[text()='15']")).click();
		Thread.sleep(20000);
		
		//Click Search buses
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(20000);
		
		//Click After 6pm under Departure time
		driver.findElement(By.xpath("//label[@for='dtAfter 6 pm'][1]")).click();
		Thread.sleep(20000);
		
		//Click Sleeper under Bus types
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER'][1]")).click();
		Thread.sleep(20000);
		
		//Select the Primo
		driver.findElement(By.xpath("//li[@class='bannerTiles fl'][1]")).click();
		Thread.sleep(20000);
		
		//Get the number of buses found
		int size = driver.findElements(By.xpath("//img[@alt='Primo']")).size();
		System.out.println("No of Buses : "+ size);
		Thread.sleep(20000);
		
		
		//Get the Bus fare and sort them in ascending order
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fare d-block']//span"));
		for (int i = 0; i < list.size(); i++) {
			String fare = list.get(i).getText();
			System.out.println(fare);
			//list.sort(fare);
			
			}
		
			
		
		
}
}

/*Launch the url https://www.redbus.in/
Enter From -Madiwala Bangalore
Enter To Koyambedu Chennai
Select the Date 10-Jun-2022
Click Search buses
Click After 6pm under Departure time
Click Sleeper under Bus types
Select the Primo
Get the number of buses found
Get the Bus fare and sort them in ascending order
Close the application*/

