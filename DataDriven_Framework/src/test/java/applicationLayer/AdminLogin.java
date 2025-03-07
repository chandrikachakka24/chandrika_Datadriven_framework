package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {

	@FindBy(name="txtUsername")
	WebElement ObjUser;
	
	@FindBy(name="txtPassword")
	WebElement ObjPass;
	
	@FindBy(id="btnLogin")
	WebElement ObjLogin;
	
	//Admin
	//Qedge123!@#
	
	public void Verify_Login(String user,String pass)
	{
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		ObjLogin.click();
		
	}
	
	
	
	
	
	
	
	
}
