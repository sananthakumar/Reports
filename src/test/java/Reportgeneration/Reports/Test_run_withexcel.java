package Reportgeneration.Reports;

import java.util.ArrayList;

public class Test_run_withexcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Excel_sample e=new Excel_sample();
		ArrayList<String>result=e.get_test_data("Settings");
		System.out.println(result);
	}

}
