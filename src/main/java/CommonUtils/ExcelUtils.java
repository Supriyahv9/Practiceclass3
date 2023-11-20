package CommonUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtils {
	
	
public String getDataFromExcelFile(String sheetName,int rowNow,int cellNow) throws Throwable {
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNow).getCell(cellNow).getStringCellValue();
		return value;

}
}
