package appTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexceldemo {

	public static void main(String[] args) throws IOException {
		//get the location
				String excelfilepath= ".\\datafiles\\FOODPRODUCT.xlsx";
				
				//inpute that location by using fileinputestream throught open the file in reading mode
				FileInputStream inputestream=new FileInputStream(excelfilepath);
				
				//get workbook from the file
				XSSFWorkbook  workbook= new XSSFWorkbook (inputestream);
				
				//get sheet from the file
		      XSSFSheet sheet =workbook.getSheetAt(0); //XSSFSheet sheet =workbook.getSheet("Sheet1");
		      
		      
				//using for loop
		      int rows=sheet.getLastRowNum();
		      int cols=sheet.getRow(1).getLastCellNum();
		      
		      for(int r=0;r<=rows;r++) 
		      {  //get row count in the sheet  
		    	XSSFRow row= sheet.getRow(r);
		    	  
		    	  for(int c=0;c<cols;c++) 
		    	  {//get cell count in particular row
		    		XSSFCell cell=row.getCell(c);  
		    		  if(cell != null) {
		    		//get datatype of the data in sheet
		    		switch (cell.getCellType()) 
		    		{
		    		case STRING :  System.out.print(cell.getStringCellValue()); break;
		    		case NUMERIC :  System.out.print(cell.getNumericCellValue()); break;
		    		case BOOLEAN :  System.out.print(cell.getBooleanCellValue()); break;
		    		}
		    		 System.out.print("  "); 
		    	  }
		    	  }
		    	  System.out.println();
		      }

	}

}
