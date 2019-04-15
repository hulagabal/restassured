package test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel2 {

	private static String[][] users = null;

	public static String[][] getUsers() throws Exception {

		Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\Mitturaj.h\\Desktop\\data.xlsx"));

		Sheet sheet = workbook.getSheet("Sheet1");

		int noOfRows = sheet.getLastRowNum();

		users = new String[noOfRows + 1][2];

		for (int i = 0; i < noOfRows + 1; i++) {
			for (int j = 0; j < 2; j++) {

				String user = sheet.getRow(i).getCell(j).getStringCellValue();

				users[i][j] = user;

			}
		}

		return users;

	}

	@DataProvider(name = "users")
	public static Object[][] getData() throws Exception {
		return getUsers();

	}

	@Test(dataProvider = "users")
	public void test33(String u, String p) {
		System.out.println(u + " " + p);
	}

}
