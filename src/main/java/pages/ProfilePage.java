package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class ProfilePage extends ProjectSpecificWrappers  {

	public ProfilePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("ToolsQA")){
			reportStep("This is not Profile Page", "Fail");
		}
	}
	
	public LoginPage clickLogOut(){
		clickByXpath("//button[@id='submit']");
		return new LoginPage(driver, test); 
	}	
	
	public ProfilePage enterSearchText(String searchText){
		enterByXpath("//input[@id='searchBox']", ""+searchText+"");
		return this; 
	}
	public BooksPage clickBookStore() throws InterruptedException{
		Thread.sleep(2000);
		WebElement element = getElementByXpath("//span[contains(text(),'Book Store')]");
		scrollToElement(element);
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Book Store')]");
		return new BooksPage(driver, test); 
	}	
	
}
