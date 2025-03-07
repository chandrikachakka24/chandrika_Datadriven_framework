package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {

	@FindBy(id ="welcome" )
	WebElement ObjWelcome;
	
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement ObjLogout;
	
	public void Verify_Logout() throws Throwable
	{
		ObjWelcome.click();
		Thread.sleep(3000);
		ObjLogout.click();
	}
}
