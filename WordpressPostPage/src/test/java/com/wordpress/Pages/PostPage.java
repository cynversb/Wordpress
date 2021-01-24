package com.wordpress.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostPage {

	WebDriver driver;
	
	/*@
	public void goToPostScreen(int value)
	{
		menuName.get(value).click();
	}
	*/
		
	@FindBy(id ="post-title-0")
	WebElement title_Post;
	
	@FindBy(className = "editor-post-publish-button__button")
	WebElement publishPost_Button;
	
	@FindBy(className = "components-text-control__input")
	WebElement link_PostAddress;
	
	@FindBy(className = "components-button")
	WebElement link_ViewPost;
	

	
	//Constructor
	public PostPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}	
	
	public void PublishPostOnclick(){
		publishPost_Button.click();
	}
	public void PublishPosttListOnclick(int value, WebDriver driver){
		
		List<WebElement> publishButton = new ArrayList<WebElement>();
		publishButton =  driver.findElements(By.className("editor-post-publish-button__button")); 
		
		if(value==1) {
			 publishButton.get(value).click();
		 }
	}
	
	public void AddTitlePost(String title){
		title_Post.clear();
		title_Post.sendKeys(title);
	}
	
	public String getLinkPostAddress()
	{
		return link_PostAddress.getAttribute("value");
	}
	
	public String getLink_ViewPost()
	{
		String newlink =link_ViewPost.findElement(By.className("is-secondary")).getAttribute("href");
		return newlink;
	}
	

	
	
	
}
