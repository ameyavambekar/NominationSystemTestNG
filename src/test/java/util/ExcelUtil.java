package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtil {

	public static Object[][] readDataFromExcel() throws IOException {// Create an empty array to store the data
		Object[][] testData = null;

		try (FileInputStream inputStream = new FileInputStream(Constants.EXCEL_FILE_PATH);
				// Open the Excel workbook
		Workbook workbook = new XSSFWorkbook(inputStream)) {
			// Get the first sheet (you can modify this to get a specific sheet by name)
			Sheet sheet = workbook.getSheetAt(0);

			// Get the total number of rows with data (excluding header)
			int rowCount = sheet.getLastRowNum();

			// Check if there are any rows with data
			if (rowCount > 0) {
				// Get the number of columns
				int columnCount = sheet.getRow(0).getLastCellNum();

				// Create the testData array based on row and column count
				testData = new Object[rowCount][columnCount];

				// Loop through each row (skip header row)
				for (int i = 1; i <= rowCount; i++) {
					Row row = sheet.getRow(i);

					// Loop through each cell in the row
					for (int j = 0; j < columnCount; j++) {
						Cell cell = row.getCell(j);

						// Check cell type and get the value accordingly
						Object cellValue = getCellValue(cell);

						// Add the value to the testData array
						testData[i - 1][j] = cellValue;
					}
				}
			}
		}

		return testData;
	}

	private static Object getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			} else {
				return cell.getNumericCellValue();
			}
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			return null;
		}
	}

	public static String getRowValueFromHeader(String header)  {
		String value = null;

		try (FileInputStream inputStream = new FileInputStream(Constants.EXCEL_FILE_PATH);
				// Open the Excel workbook
		Workbook workbook = new XSSFWorkbook(inputStream)) {
			// Get the first sheet (you can modify this to get a specific sheet by name)
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			int columnCount = sheet.getRow(0).getLastCellNum();
			int count = 0;
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row.getCell(j);
				if (getCellValue(cell).toString().equals(header)) {
					break;
				} else {
					count++;
				}
			}
			int rowCount = sheet.getLastRowNum();

			// Loop through each row (skip header row)
			for (int i = 1; i <= rowCount; i++) {
				Row rowData = sheet.getRow(i);
				Cell cell = rowData.getCell(count);
				// Check cell type and get the value accordingly
				Object cellValue = getCellValue(cell);
				value = cellValue.toString();
				// Add the value to the testData array
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}