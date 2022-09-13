package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils2(String excelPath, String sheetName) {
		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//
//		getRowCount();
//		getCellData();
//	}

	public static void getCellData(int rowNumber, int colNum) {

//			String excelPath = "./data/Data.xlsx";
//			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
//			XSSFSheet sheet = workbook.getSheet("Sheet1");
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNumber).getCell(colNum));
		System.out.println(value);
	}

	public static void getRowCount() {

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of Rows: " + rowCount);

	}
}
