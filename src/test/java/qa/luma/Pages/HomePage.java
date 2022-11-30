package qa.luma.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.*;

import qa.luma.Base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//a[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath = "//ul//li[@class='authorization-link']")
	WebElement loginBtn;
	
	

	public String title() {
		String mytitle = "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		return mytitle;
	}
	
	public Boolean logo() {
		log.info("Checking Application Logo.");
		return logo.isDisplayed();
	}
	
	public void clickLogin() {
		log.info("Clicking on Login Button.");
		loginBtn.click();
	}
	


}
