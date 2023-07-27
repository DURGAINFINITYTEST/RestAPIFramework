package api.uitlities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtility {

	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	String path;

	public ExcelDataUtility(String path) {

		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {

		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInputStream.close();
		return cellCount;
	}

	public String getCevoidllData(String sheetName, int rowNum, int colNum) throws IOException {
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";

		}

		workbook.close();
		fileInputStream.close();
		return data;

	}
}