package utils;

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		
		String excelPath ="./data/Data.xlsx";
		String sheetName ="Sheet1";
		
		ExcelUtils2 excel = new ExcelUtils2(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(1,0);
		excel.getCellData(1,1);
		excel.getCellData(1,2);
		excel.getCellData(1,3);
	}

}
