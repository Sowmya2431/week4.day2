package week4.day2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Nykaa {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
		//Click Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);
	    WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	    WebElement search = driver.findElement(By.cssSelector("div#scroller-container>div:nth-of-type(7)>a"));;
	    Thread.sleep(2000);
	        builder.moveToElement(brands).click(search).perform();
	        
	     //Check the title contains L'Oreal Paris   
	        String title1 = driver.getTitle();
	        System.out.println("The title of the page is :" + title1);
	        String title2 = "L'Oreal Paris";
	        boolean contains = title1.contains(title2);
	        if(title1.contains(title2)) {
	        	System.out.println("The title contains L'Oreal Paris");
	        }else {
	        	System.out.println("the title does not contain L'Oreal Paris");
	        }
	        
	        //Click sort By and select customer top rated
	       
	        driver.findElement(By.className("sort-name")).click();
	        driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	        
	        //Click Category and click Hair->Click haircare->Shampoo
	        driver.findElement(By.xpath("//span[text()='Category']")).click();
	        Thread.sleep(30000);
	        
	        //Click on Hair
	        driver.findElement(By.xpath("//div[@class=' css-b5p5ep']")).click();
	        Thread.sleep(30000);
	        
	        //Click on Hair care
	        driver.findElement(By.xpath(" //span[text()='Hair Care']")).click();
	        Thread.sleep(30000);
	        
	        //Click on Shampoo
	        driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']")).click();
	        Thread.sleep(30000);
	        
	        //Click->Concern
	        driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj']/span)[6]")).click();
	        Thread.sleep(30000);
	        
	        //Click on Color protection
	        driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']")).click();
	        Thread.sleep(30000);
	        
			//check whether the Filter is applied with Shampoo
	        boolean enabled = driver.findElement(By.xpath("//span[text()='Filters Applied']")).isEnabled();
	        System.out.println("Filters are applied: "+ enabled);
	        Thread.sleep(30000);
	        
	        //Click on L'Oreal Paris Colour Protect Shampoo
	        driver.findElement(By.xpath("(//img[@class='css-11gn9r6'])[1]")).click();
	        Thread.sleep(30000);
	        
	        //Handle new window
	        Set<String> windowHandles = driver.getWindowHandles();
	        List<String> list1=new ArrayList<>(windowHandles);
			driver.switchTo().window(list1.get(1));
			
			//GO to the new window and select size as 175m
			WebElement size = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
			Select dd = new Select (size);
			dd.selectByValue("0");
			Thread.sleep(30000);
			
			//Print MRP
			String mrp = driver.findElement(By.xpath("(//span[text()='₹189'])[1]")).getText();
			System.out.println("MRP of the product: " + mrp);
			Thread.sleep(30000);
			
			//Click on ADD to BAG
			driver.findElement(By.xpath("//button[@class=' css-12z4fj0']//span")).click();
			Thread.sleep(30000);
			
			//Go to Shopping Bag
			driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
			Thread.sleep(30000);
			
			//switch to frame
			WebElement shoppingBag = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
			driver.switchTo().frame(shoppingBag);
			Thread.sleep(30000);
			
			//Print the Grand Total amount
			String grandTotal = driver.findElement(By.xpath("(//div[text()='259'])[2]")).getText();
			System.out.println("GrandTotal :" +grandTotal);
			Thread.sleep(30000);
			
			//Click Proceed
			driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			Thread.sleep(30000);
			
			//Click on Continue as Guest
			driver.findElement(By.xpath("//button[@class='btn full big']")).click();
			Thread.sleep(30000);
			
			//Check if this grand total is the same in step 14
			String Gt = driver.findElement(By.xpath("//span[text()='259']")).getText();
			System.out.println("GT in checkout page :" +Gt);
			if(grandTotal==Gt) {
				System.out.println("EQUAL");
			}
			else {
				System.out.println("NOT EQUAL");
			}
			
			driver.switchTo().frame(0);
			driver.switchTo().window(list1.get(0));
		
			driver.quit();
			
			
	        
	        
	        
	        
	        
		
	}

}
