package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class LoginPage extends ProjectSpecificWrappers  {

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("ToolsQA")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public LoginPage enterUserName(){
		//driver.findElement(By.id("username")).sendKeys("username");
		enterById("userName", username);
		return this;
	}
	
	public LoginPage enterPassword(){
		enterById("password", password);
		return this;
		
	}
	
	public ProfilePage clickLogin(){
		clickById("login");		
		return new ProfilePage(driver, test);
	}
	
	public LoginPage clickLoginForFailure(){
		clickById("login");
		return this;
	}
	
	public LoginPage clickNewUser(){
		clickById("newUser");
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
