package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	private static FileInputStream fileInputStream;
	private static Workbook workbook;
	private static Sheet sheet;
	private static FileOutputStream fileOutputStream;
	private static Row row;
	private static Cell cell;

	public static void main(String[] args) throws Exception {
		fileInputStream = new FileInputStream("./data.xlsx");
		workbook = WorkbookFactory.create(fileInputStream);
		sheet = workbook.getSheet("Sheet1");
		int noOfRows=sheet.getLastRowNum();
		System.out.println("Number of rows "+noOfRows);
		
		row=sheet.createRow(1);
		cell=row.createCell(0);
		
		cell.setCellValue("Me");
		System.out.println(cell.getStringCellValue());
		System.out.println(noOfRows);
		
		fileOutputStream=new FileOutputStream("./data.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.flush();
		fileOutputStream.close();
		

	}

}
