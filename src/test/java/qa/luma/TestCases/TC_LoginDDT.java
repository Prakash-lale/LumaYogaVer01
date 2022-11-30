package qa.luma.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.luma.Base.TestBase;
import qa.luma.Pages.HomePage;
import qa.luma.Pages.LoginPage;
import qa.luma.Utils.allUtils;

public class TC_LoginDDT extends TestBase{

	public TC_LoginDDT() {
		super();
	}
	
	LoginPage lp;
	HomePage hp;
	
	@DataProvider(name = "Data For Login")
	public Object[][] LoginDataFromExcel() throws IOException {
		
		Object[][] data = allUtils.readExcelData();
		return data;
	}
	
	@Test(dataProvider = "Data For Login")
	public void LoginDDTTest(String uemail, String pwd) {
		hp = new HomePage();
		hp.clickLogin();
		lp = new LoginPage();
		lp.login(uemail,pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertTrue(lp.varifyUser().contains("Welcome"), "Check For User Successful Login"); 
		
	}
	
}
