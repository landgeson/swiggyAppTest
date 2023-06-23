package appTest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteexcelDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//creat a workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//creat a sheet
		XSSFSheet sheet= workbook.createSheet("EMP INFO");
		
		//pass the data in  a sheet
		Object empdata[][]= { {"PRICE", "FOOD_NAME", "HOTEL_NAME"},
				              {"196.19", "2 McVeggie Burger", "McDonald's"},
				              {"180", "Veg Cheese Pizza [8 Slices]", "Froozeto"},
				              {"130.48", "Fries (L)", "McDonald's"},
				              {"55", "Cold Coffe", "Froozeto"},};
		//using for loop
		//calculate the rows and column
		 int rows=empdata.length;
		int cols=empdata[0].length;
		System.out.println(rows);
		System.out.println(cols);
		
		for(int r=0;r<rows;r++) {
			
			XSSFRow row=sheet.createRow(r);
			
			for(int c=0;c<cols;c++) {
				XSSFCell cell= row.createCell(c);
				Object value=empdata[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			}
		}
		String filepath=".\\datafiles\\HOTELBOOK.xlsx";
		FileOutputStream outputstream=new FileOutputStream(filepath);
		workbook.write(outputstream);
		
		outputstream.close();
		
		System.out.println("HOTELBOOK Xlsx file written successfully");
		
	}
	

}
