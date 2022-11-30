package qa.luma.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;


import qa.luma.Base.TestBase;
import qa.luma.Pages.HomePage;

public class TC_HomePage_01 extends TestBase{
	
	public TC_HomePage_01() {
		super();
	}
	
	HomePage hp;
	
	@Test(priority = 1,groups = {"varifyApplication"})
	public void checkTitle() {
		log.info("Checking HomePage Title");
		Assert.assertTrue(driver.getTitle().contains("Home Page - Magento eCommerce"), "Home Page Title Check");
	}
	
	@Test(priority = 2,groups = {"varifyApplication"},dependsOnMethods = {"checkTitle"})
	public void checkLogo() {
		hp = new HomePage();
		Assert.assertTrue(hp.logo());
	}
	
	@Test(priority = 3,dependsOnGroups = {"varifyApplication"})
	public void checkLoginButton() {
		hp = new HomePage();
		hp.clickLogin();
		Assert.assertTrue(driver.getTitle().contains("Customer Login Magento Commerce"));
	} 

}
