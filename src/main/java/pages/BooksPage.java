package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class BooksPage extends ProjectSpecificWrappers{
	

	public BooksPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("ToolsQA")){
			reportStep("This is not Books page", "Fail");
		}
	}
	public BooksPage enterSearchText(String searchText){
		enterByXpath("//input[@id='searchBox']", ""+searchText+"");
		return this; 
	}
	
	
	public BookResultPage clickSearchResult(String searchText){
		clickByXpath("//a[contains(text(),'"+searchText+"')]");
		return new BookResultPage(driver,test);
		
	}

	public LoginPage clickLogOut(){
		clickByXpath("//button[@id='submit']");
		return new LoginPage(driver, test); 
	}	
	
	
		
}