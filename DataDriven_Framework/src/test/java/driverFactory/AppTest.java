
package driverFactory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilities.ExcelFileUtil;
import applicationLayer.AddEmp;
import config.Base;

public class AppTest extends Base {

	String inputpath = "./FileInput/Employee.xlsx";
	String outputpath = "./FileOutput/DataDrivenResults.xlsx";
	ExtentReports reports;
	ExtentTest logger;
	String TCSheet ="EmpData";
	
	@Test
	public void startTest() throws Throwable 
	{
		System.out.println("am test");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl.rowCount(TCSheet);
		Reporter.log("No of rows are::"+rc,true);
		
		for(int i=1;i<=rc;i++)
		{
            reports=new ExtentReports("./target/reports.html");
			logger = reports.startTest("Validate Add Emp");
			logger.assignAuthor("chandrika");
			
			String Fname = xl.getCellData(TCSheet, i, 0);
			String Mname = xl.getCellData(TCSheet, i, 1);
			String Lname = xl.getCellData(TCSheet, i, 2);
			
			AddEmp emp =  PageFactory.initElements(driver, AddEmp.class);
			
			boolean res = emp.verifyEmp(Fname, Mname, Lname);
			if(res)
			{
				xl.setCellData(TCSheet, i, 3, "pass", outputpath);
			}
			else
			{
				xl.setCellData(TCSheet, i, 3, "fail", outputpath);
			}
		
			reports.endTest(logger);
			reports.flush();	
		}		
	}
		
}
