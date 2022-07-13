package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();  
		
		ChromeDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//Launch URL
		driver.get("http://www.leafground.com/pages/Window.html");
		
		//Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		
		//Handle the window
		Set<String> handles = driver.getWindowHandles();
		List<String> list=new ArrayList<>(handles);
		driver.switchTo().window(list.get(1));
		System.out.println("The current Title: "+ driver.getTitle());
	
		System.out.println("*******************************************");
		
		//Come back to base window
		driver.switchTo().window(list.get(0));
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		//Handle multiple windows
		Set<String> handles1 = driver.getWindowHandles();
		/*List<String> list1=new ArrayList<>(handles1);
		for (int i= 0; i< list1.size(); i++) {
		driver.switchTo().window(list1.get(i));
			}*/
		System.out.println("No of windows :" + driver.getWindowHandles().size());
		System.out.println("*******************************************");
		
		//Come back to base window
		driver.switchTo().window(list.get(0));
				
		//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		//Handle the Windows
		Set<String> handles2 = driver.getWindowHandles();
		List<String> list2=new ArrayList<>(handles2);
		for (int i = 0; i < list2.size(); i++) {
			String title1 = driver.switchTo().window(list2.get(i)).getTitle();
		
			System.out.println("Do not close me window titles :" + title1);
		
			}
		System.out.println("*******************************************");
		
		
		//Come back to base window
		driver.switchTo().window(list.get(0));
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		
		Set<String> handles3 = driver.getWindowHandles();
		List<String> list3=new ArrayList<>(handles2);
		for (int i = 0; i < list3.size(); i++) {
			String title2 = driver.switchTo().window(list3.get(i)).getTitle();
		
			System.out.println("Titles :" + title2);
			}
		//Come back to base window
				driver.switchTo().window(list.get(0));
				driver.quit();
		
		
		
		

	}

}
