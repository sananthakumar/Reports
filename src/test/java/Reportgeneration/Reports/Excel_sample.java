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

public class Excel_sample {

	public ArrayList<String> get_test_data(String testcase) {
		int k = 0;
		int column = 0;
		ArrayList<String> test_val=new ArrayList();
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
	
			//getting bthe correct sheet
			
			for(int i=0;i<count;i++) {
				if(wrkbook.getSheetName(i).equalsIgnoreCase("Regression")) {
					// gettinh the sheet
					XSSFSheet smk_sheet = wrkbook.getSheetAt(i);
					// iterating the row
					Iterator<Row> row = smk_sheet.iterator();
					Row first = row.next();
					
					Iterator<Cell> ce = first.cellIterator();
					
					while(ce.hasNext()) {
						Cell value=ce.next();
						if(value.getStringCellValue().equalsIgnoreCase(testcase)) {
							
							System.out.println(value);
							column = k;
						}System.out.println(k);
						k++;
						
						}
					System.out.println("column "+column);
					
					
				////once coloumn is identified then scan entire testcase coloum to identify Settings testcase row
				while(row.hasNext()) {	
					Row r=row.next();
					System.out.println(r.getCell(column).getStringCellValue());
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("settings")) {
						Iterator <Cell> cel=r.iterator();
						while(cel.hasNext()) {
							Cell C=cel.next();
							if(C.getCellTypeEnum()==CellType.STRING) {
								test_val.add(C.getStringCellValue());
							}
							else {
								test_val.add(NumberToTextConverter.toText(C.getNumericCellValue()));
							}
							//System.out.println(C.getStringCellValue());
							
						}
                        break;
					}
				}
				}
				}
		}
		 catch (Exception e) {
				e.printStackTrace();
				System.out.println("inside catch");
			}
		return test_val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
}

