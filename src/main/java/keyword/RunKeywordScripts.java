package keyword;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.ProjectSpecificWrappers;

public class RunKeywordScripts extends ProjectSpecificWrappers{

	@BeforeClass
	public void setup(){
		browserName 	= "chrome";
		testCaseName 	= "TC01 - Login";
		testDescription = "Login to OpenTaps Using Keyword";	
		category = "Regression";
		authors="Edd";
	}

	@Test
	public void runScripts() throws IOException {

		CallWrappersUsingKeyword keywords = new CallWrappersUsingKeyword(driver, test);

		try {
			FileInputStream fis = new FileInputStream("./Keywords/KeywordDriver.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			int rowCount = sheet.getLastRowNum();			

			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					System.out.println(driver);
					if(row.getCell(3).getStringCellValue().toLowerCase().equals("yes"))
						keywords.getAndCallKeyword("./keywords/"+row.getCell(1).getStringCellValue()+".xlsx");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
