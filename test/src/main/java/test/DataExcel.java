package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bsh.This;

public class DataExcel {

	private static String[][] users;

	public static String[][] getData() throws Exception {

		Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\Mitturaj.h\\Desktop\\data.xlsx"));

		Sheet sheet = workbook.getSheet("Sheet1");

		int noOfRows = sheet.getLastRowNum() + 1;
		System.out.println(noOfRows);

		users = new String[noOfRows][2];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < 2; j++) {

				String user = sheet.getRow(i).getCell(j).getStringCellValue();

				users[i][j] = user;
			}
		}
		return users;

	}

	@DataProvider(name = "users")
	public static Object[][] getUsers() throws Exception {
		return getData();
	}

	@Test(dataProvider = "users")
	public void login(String username, String pass) {
		System.out.println(username + " " + pass);

	}

	// By using File Reader class
	static void getProps() throws Exception {
		FileReader fileReader = new FileReader("C:\\repos\\test\\src\\main\\java\\test\\config.properties");
		Properties properties = new Properties();

		properties.load(fileReader);

		System.out.println("By using File Reader: " + properties.getProperty("username"));

	}

	// By using file input stream
	static void getProp() throws Exception {

		FileInputStream fileInputStream = new FileInputStream(
				"C:\\repos\\test\\src\\main\\java\\test\\config.properties");

		Properties properties = new Properties();
		properties.load(fileInputStream);

		System.out.println("By using File Input stream class: " + properties.getProperty("username"));

	}

	static void setProperties() {
		File file = new File("C:\\repos\\test\\src\\main\\java\\test\\config.properties");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			Properties properties = new Properties();

			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);

			properties.setProperty("work", "Mangalore");

			fileOutputStream = new FileOutputStream(file);
			properties.store(fileOutputStream, "ADDED");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {

		getProps();
		getProp();
		setProperties();

	}
}
