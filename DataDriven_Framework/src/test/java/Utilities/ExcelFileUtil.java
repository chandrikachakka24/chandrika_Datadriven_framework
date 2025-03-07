package Utilities;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFCellStyle;
	import org.apache.poi.xssf.usermodel.XSSFFont;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelFileUtil {

		XSSFWorkbook wb;
		public ExcelFileUtil(String Excelpath) throws IOException
		
		{
			FileInputStream fi = new FileInputStream(Excelpath);
			wb = new XSSFWorkbook(fi);
		}
	
		/*
		 * public ExcelFileUtil() { // TODO Auto-generated constructor stub }
		 */

		public int rowCount(String sheetname)
		{
			return wb.getSheet(sheetname).getLastRowNum();
		}
		
		public String getCellData(String sheetName,int row,int colomn)
		{
			String data="";
			if(wb.getSheet(sheetName).getRow(row).getCell(colomn).getCellType()==CellType.NUMERIC)
					 {
				int celldata=(int)wb.getSheet(sheetName).getRow(row).getCell(colomn).getNumericCellValue();
				data = String.valueOf(celldata);
			}
			else
			{
				data=wb.getSheet(sheetName).getRow(row).getCell(colomn).getStringCellValue();
				
			}
			return data ;
		}	
		public void setCellData(String sheetName,int row,int column,String status,String WriteExcel) throws Throwable
		{
			XSSFSheet ws = wb.getSheet(sheetName);
			XSSFRow rowNum = ws.getRow(row);
			XSSFCell cell = rowNum.createCell(column);
			cell.setCellValue(status);
			if(status.equalsIgnoreCase("pass"))
			{
				XSSFCellStyle style = wb.createCellStyle();
				XSSFFont font=wb.createFont();
				font.setColor(IndexedColors.GREEN.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
			}
				
			else if(status.equalsIgnoreCase("fail"))
			{
				XSSFCellStyle style = wb.createCellStyle();
				XSSFFont font=wb.createFont();
				font.setColor(IndexedColors.RED.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
			}
			else if(status.equalsIgnoreCase("blocked"))
			{
				XSSFCellStyle style = wb.createCellStyle();
				XSSFFont font=wb.createFont();
				font.setColor(IndexedColors.BLUE.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
			}
			FileOutputStream fo = new FileOutputStream(WriteExcel);
			wb.write(fo);
			
		}
		public static void main(String[] args) throws Throwable {
			
			ExcelFileUtil xl = new ExcelFileUtil("C:\\HybridFramework");
			int rc = xl.rowCount("Emp");
			System.out.println(rc);
			for(int i=1;i<=rc;i++)
			{
				String fname = xl.getCellData("Emp", i, 0);
				String mname = xl.getCellData("Emp", i, 1);	
				String lname = xl.getCellData("Emp", i, 2);
				String eid = xl.getCellData("Emp", i, 3);
				System.out.println(fname+"   "+mname+"    "+lname+"    "+eid);
				xl.setCellData("Emp", i, 4, "pass", "C:\\HybridFramework");
			}
			
			
		}
		
	}

	

	
	
	
	
	
	
	
	
