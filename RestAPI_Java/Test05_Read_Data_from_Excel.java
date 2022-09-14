package RestAPI;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test05_Read_Data_from_Excel {
	
	

	public static void main(String[] args) {

		getRowCount();
		getCellData();
	}

	public static void getCellData() {

		try {

			String excelPath = "./data/Data.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);

			XSSFSheet sheet = workbook.getSheet("Sheet1");

			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(1).getCell(3));
			System.out.println(value);

		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public static void getRowCount() {
		try {
			String excelPath = "./data/Data.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows: " + rowCount);

		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

}
