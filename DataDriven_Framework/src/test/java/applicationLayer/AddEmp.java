package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmp {
	
	WebDriver driver;
	public AddEmp(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id='menu_pim_viewPimModule']/b")
	WebElement ObjPim;
	
	@FindBy(name = "btnAdd")
	WebElement ObjAdd;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement ObjFname;
	
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement ObjMname;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement ObjLname;
	
	@FindBy(xpath = "//input[@name='employeeId']")
	WebElement ObjEID;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement ObjSave;
	
	@FindBy(name  = "personal[txtEmployeeId]")
	WebElement ObjID;
	
	public boolean verifyEmp(String Firstname,String Middlename, String Lastname) throws Throwable
	{
		
		Actions ac=new Actions(driver);
		ac.moveToElement(ObjPim).click().perform();
		Thread.sleep(3000);
		
		ac.moveToElement(ObjAdd).click().perform();
		Thread.sleep(3000);
	//	ac.moveToElement(ObjFname)ac.sendKeys()
		ObjFname.sendKeys(Firstname);
		ObjMname.sendKeys(Middlename);
		ObjLname.sendKeys(Lastname);
		String Exp_Data = ObjEID.getAttribute("value");
		ac.moveToElement(ObjSave).click().perform();
		String Act_Data = ObjID.getAttribute("value");
		if (Act_Data.equals(Exp_Data)) {
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
