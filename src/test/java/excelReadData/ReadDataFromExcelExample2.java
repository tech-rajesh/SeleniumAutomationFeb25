package excelReadData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelExample2 {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("./testdata/RegistrationData.xlsx");
		//Workbook
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("smokeTest");
		//HSSFSheet sheetByIndex = workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("No of Row are: " + rowCount );
		System.out.println("No of Column are: " + columnCount);
		
		
		for(int i=1; i <= rowCount; i++ ) {
			
			
			XSSFRow currentRow = sheet.getRow(i);
			
//			for(int j = 0; j<=columnCount; j++) {
//				
//				String Value = currentRow.getCell(j).toString();
//				System.out.println(Value);
//			}
			
			String FirstName = sheet.getRow(i).getCell(0).toString();
			String LastName = sheet.getRow(i).getCell(1).toString();
			String email = sheet.getRow(i).getCell(2).toString();
			String mobile = sheet.getRow(i).getCell(0).toString();
			String address = sheet.getRow(i).getCell(0).toString();
			
			
			System.out.println("FirstName " + FirstName);
			System.out.println("email " + email);
			System.out.println("------------------------");
			
			
		}
		
		
		
		
		

	}

}
