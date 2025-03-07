package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {

	public static void main(String[] args) throws InterruptedException {
	
	
		
		WebDriver driver =  new ChromeDriver();
		
		try {
		driver.get("http://orangehrm.qedgetech.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(5000);
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id("btnAdd")).click();
		WebElement textbox = driver.findElement(By.id("employeeId"));
		
		String value = textbox.getAttribute("0348");
		System.out.println(value);
		Thread.sleep(5000);
		}
		
		finally {
            // Close the browser
            driver.quit();
        
		

	   }
	
     }
}
