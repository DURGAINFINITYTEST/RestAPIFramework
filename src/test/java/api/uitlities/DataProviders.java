package api.uitlities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "Data")
	public String[][] getAllData() throws Exception {

		ExcelDataUtility ex = new ExcelDataUtility("C:\\Users\\katak\\OneDrive\\Desktop\\jan.xlsx");
		int rownum = ex.getRowCount("Durga");
		int colcount = ex.getCellCount("Durga", 1);

		String apiData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colcount; j++) {
				apiData[i - 1][j] = ex.getCevoidllData("Durga", i, j);

			}
		}
		return apiData;

	}

}
