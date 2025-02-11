package example09.DataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public int getRowCount(String xlfile, String xlsheet) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}

	public int getCellCount(String xlfile, String xlsheet, int rowNum) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}

	public String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			return data;
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fis.close();
		return data;
	}

	public void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data)
			throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);

		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		
		cell.setCellValue(data);
		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}

	public void fillGreenColor(String xlfile, String xlsheet, int rowNum, int colNum) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);

		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}

	public void fillRedColor(String xlfile, String xlsheet, int rowNum, int colNum) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);

		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
}
