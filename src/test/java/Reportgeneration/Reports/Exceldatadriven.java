package Reportgeneration.Reports;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatadriven {

	public static void main(String[] args) {
		try {
			// File file = new File(); //creating a new file instance
			// FileInputStream fis = new FileInputStream();
			FileInputStream fname = new FileInputStream(
   					"C:\\Users\\91999\\Downloads\\Selenium_learning\\Testdata.xlsx");
			// XSSFWorkbook wrkbook=new XSSFWorkbook();
			XSSFWorkbook wrkbook = new XSSFWorkbook(fname);
			int count = wrkbook.getNumberOfSheets();
			System.out.println(count);
			// K is declared to increment then onl;ly we can find column value
			int k = 0;
			int column = 0;

			for (int i = 0; i < count; i++) {
				if (wrkbook.getSheetName(i).equalsIgnoreCase("smoke")) {
					// gettinh the sheet
					XSSFSheet smk_sheet = wrkbook.getSheetAt(i);
					// iterating the row
					Iterator<Row> row = smk_sheet.iterator();
					Row first = row.next();
					// Itertaing the cella in the row
					Iterator<Cell> ce = first.cellIterator();
					// For finding the crt column
					while (ce.hasNext()) {
						Cell value = ce.next();
						if (value.getStringCellValue().equalsIgnoreCase("pwd")) {
							// Code to build
							System.out.println(value);
							column = k;
						}
						k++;
					}
					System.out.println(column);
						while (row.hasNext()) {
							Row r = row.next();
							if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Settings")) {

								Iterator<Cell> cel = r.cellIterator();
								while (cel.hasNext()) {
									Cell value_1 = cel.next();
									System.out.println(value_1.getStringCellValue());
								}

							}
						}
						
					}
					break;
				}
			}

					 catch (Exception e) {
			e.printStackTrace();
			System.out.println("inside catch");
		}
		// System.out.println(smk_sheet.getActiveCell());
	}

}