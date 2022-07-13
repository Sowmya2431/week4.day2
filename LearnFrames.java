package week4.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		// store the text value from the main page
		String textValue = driver.findElement(By.xpath("//label/span")).getText();
		
		// switch to frame1
		driver.switchTo().frame("frame1");
		
		// set the value of the textbar to the value stored
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys(textValue);
		
		//Switch the context
		driver.switchTo().defaultContent();
		
		//find frame 2
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		
		//Select values in dropdown:
		WebElement animals = driver.findElement(By.className("col-lg-3"));
		Select dd = new Select(animals);
		dd.selectByValue("babycat");
		
		//switch the context
		driver.switchTo().defaultContent();
		
		// To find the nested frame , first switch to frame1
		WebElement frame1 = driver.findElement(By.id("frame1"));
		
		// switch to frame1
		driver.switchTo().frame(frame1);
		
		//Find Frame3
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);
		
		//Find the check box element in Frame3
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		//Check whether the box is selected or not
		System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
		
		
		
		driver.switchTo().defaultContent();
		driver.close();
		
		
		
	}

}
