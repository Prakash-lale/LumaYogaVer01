package qa.luma.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import qa.luma.Base.TestBase;

public class allUtils extends TestBase {

	public static ExtentReports extentReportGenerator() {

		ExtentReports extentreports = new ExtentReports();

		String timestamp = new SimpleDateFormat("yyyy-mm-dd-hh-mm-hh-ss").format(new Date());
		String reportname = "Report-"+timestamp;

		String reportPath = System.getProperty("user.dir")+"\\Reports\\"+reportname+".html";

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportPath);

		extentreports.attachReporter(sparkreporter);
		
		sparkreporter.config().setReportName("Luma Yoga");
		sparkreporter.config().setDocumentTitle("Luma Yoga Test Reports");
		extentreports.setSystemInfo("Tester", "Prakash Lale");

		return extentreports;
	}

	public static Object[][] readExcelData() throws IOException {
		File file = new File(
				"C:\\Users\\PRAKASH\\eclipse-workspace\\NewProject01\\LumaYogaV1\\src\\test\\java\\qa\\luma\\TestData\\luma-login.xlsx");
		System.out.println("Excel File Exist" + file.exists());

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("LumaYoga Login Details");

		int numRows = sheet.getPhysicalNumberOfRows();

		int numCols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[numRows - 1][numCols];

		for (int i = 0; i < numRows - 1; i++) {

			for (int j = 0; j < numCols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		return data;
	}

	public static String getScreenshot(String testname) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;

		String timestampe = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());

		File sourceFile = tk.getScreenshotAs(OutputType.FILE);

		String filepath = System.getProperty("user.dir") + "\\Screenshots\\" + testname + "-" + timestampe + ".png";

		File destFile = new File(filepath);

		FileHandler.copy(sourceFile, destFile);

		return filepath;
	}

}
