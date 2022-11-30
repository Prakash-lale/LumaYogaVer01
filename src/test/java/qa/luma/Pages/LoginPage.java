package qa.luma.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.luma.Base.TestBase;
import qa.luma.Utils.readConfig;

public class LoginPage extends TestBase{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	readConfig readconfig = new readConfig();
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='send2']//span[text() = 'Sign In']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Welcome')]")
	WebElement varUser;
	
	@FindBy(xpath = "//a//span[text() = 'Forgot Your Password?']")
	WebElement forgetPassword;
	
	@FindBy(xpath = "//a//span[text() = 'Create an Account']")
	WebElement createAccountButton;
	
	public void login(String uemail, String upwd) {
		log.info("Entering user Email.");
		email.sendKeys(uemail);
		log.info("Entering Password");
		password.sendKeys(upwd);
		log.info("Click on signIn Button.");
		signInBtn.click();
	}
	
	
	public String varifyUser() {
		log.info("varifying user with welcome Message.");
		return varUser.getText();
	}
	
	public void forgetPassword() {
		log.info("Checking Forget Password.");
		forgetPassword.click();
	}
	
	public void clickCreateAccountBtn() {
		log.info("Chekcing Create Account Button.");
		createAccountButton.click();
	}
}
