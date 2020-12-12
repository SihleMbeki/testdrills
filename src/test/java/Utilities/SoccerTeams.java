package Utilities;

import org.testng.annotations.DataProvider;

public class SoccerTeams {
	@DataProvider
	public Object[][] getTableData() {
		Object[][] test=new Object[2][2];
		test[0][0]="Johne";
		test[0][1]="Doe";
		test[1][0]="Sihle";
		test[1][1]="Mbeki";
		return test;
	}
}
