package qa.luma.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import qa.luma.Base.TestBase;

public class listeners extends TestBase implements ITestListener{
	
	ExtentReports extent = allUtils.extentReportGenerator();
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest("Test Started "+result.getMethod().getMethodName());
		System.out.println("This is on test Start");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed "+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed "+result.getMethod().getMethodName());
		try {
			String sspath = allUtils.getScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(sspath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped "+result.getMethod().getMethodName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
