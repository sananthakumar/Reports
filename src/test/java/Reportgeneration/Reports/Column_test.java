package Reportgeneration.Reports;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Column_test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=0;
		int con=0;
		ArrayList<String> test_val=new ArrayList();
		try {
			// File file = new File(); //creating a new file instance
			// FileInputStream fis = new FileInputStream();
			FileInputStream fname = new FileInputStream(
					"C:\\Users\\91999\\Downloads\\Selenium_learning\\Column_test.xlsx");
			// XSSFWorkbook wrkbook=new XSSFWorkbook();
			XSSFWorkbook wrkbook = new XSSFWorkbook(fname);
			int count = wrkbook.getNumberOfSheets();
			System.out.println(count);
			
			XSSFSheet sheet=wrkbook.getSheetAt(0);
			
			Iterator<Row> rows=sheet.iterator();
			Row first=rows.next();
			Iterator<Cell>cel=first.iterator();
			while(cel.hasNext()) {
				Cell value=cel.next();
				if(value.getStringCellValue().equalsIgnoreCase("TC_01")) {
				con=k;	
				}
				k++;
			}
			while(rows.hasNext()) {	
				Row r=rows.next();
				if(r.getCell(con).getCellTypeEnum()==CellType.STRING) {
				System.out.println(r.getCell(con).getStringCellValue());
				}
				else
				{
					System.out.println(NumberToTextConverter.toText(r.getCell(con).getNumericCellValue()));
				}
			}
			System.out.println(con);
	}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("inside catch");
		}

}

}