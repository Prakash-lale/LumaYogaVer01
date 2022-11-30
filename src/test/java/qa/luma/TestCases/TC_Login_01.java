package qa.luma.TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import qa.luma.Base.TestBase;
import qa.luma.Pages.HomePage;
import qa.luma.Pages.LoginPage;
import qa.luma.Utils.readConfig;

public class TC_Login_01 extends TestBase{
	
	public TC_Login_01()
	{
		super();
	}
	
	readConfig readconfig = new readConfig();;
	
	LoginPage lp;
	HomePage hp;
	
	@Test(priority = 1)
	public void loginTest() {
		hp = new HomePage();
		hp.clickLogin();
		lp = new LoginPage();
		lp.login(readconfig.getUserEmail(),readconfig.getUserPassword());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertTrue(lp.varifyUser().contains("Welcome"), "Check For User Successful Login"); 
		
	}
	
	@Test(priority = 2)
	public void forgetPasswordTest() {
		hp = new HomePage();
		hp.clickLogin();
		lp = new LoginPage();
		lp.forgetPassword();
		Assert.assertTrue(driver.getTitle().contains("Forgot Your Password?"));
	}
	
	@Test(priority = 3)
	public void createAccountBtnTest() {
		hp = new HomePage();
		hp.clickLogin();
		lp = new LoginPage();
		lp.clickCreateAccountBtn();
		Assert.assertTrue(driver.getTitle().contains("Create New Customer Account"));
	}

}
