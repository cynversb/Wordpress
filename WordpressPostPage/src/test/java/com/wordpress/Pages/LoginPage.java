package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
		//PageFactory.initElements(driver, ldriver);
	}

	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(how=How.ID, using="user_pass")
	WebElement password;
	
	@FindBy(how=How.ID, using="wp-submit")
	WebElement submit_button;
	
	@FindBy(linkText = "Lost your password?")
	WebElement forget_password_linktext;
	

	public void login_Wordpress(String user_id, String passwrd){
		username.sendKeys(user_id);
		password.sendKeys(passwrd);
		submit_button.click();
	}
}
