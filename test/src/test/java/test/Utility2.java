package test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Utility2 {
	private static FileInputStream fileInputStream;
	private static Workbook workbook;
	private static Sheet sheet;

	static String[][] users = null;

	public static String[][] getdata() throws Exception {
		fileInputStream = new FileInputStream("./data.xlsx");
		workbook = WorkbookFactory.create(fileInputStream);
		sheet = workbook.getSheet("Sheet1");
		int noOfRows = sheet.getLastRowNum();
		System.out.println("Number of rows " + noOfRows);
		users = new String[noOfRows + 1][2];
		for (int i = 0; i < noOfRows + 1; i++) {
			for (int j = 0; j < 2; j++) {
				String user = (sheet.getRow(i).getCell(j)).getStringCellValue();
				users[i][j] = user;
			}
		}
		return users;
	}

	@DataProvider(name = "users")
	public static Object[][] getUsers() throws Exception {
		return getdata();

	}
}
