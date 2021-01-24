package com.wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPageDashboard {

	WebDriver driver;
	
	
	public PostPageDashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(className = "page-title-action")
	WebElement New_button;
	
	@FindBy(id = "bulk-action-selector-bottom")
	WebElement option_combobox;
	
	@FindBy(id = "doaction2")
	WebElement apply_button;
	
	@FindBy(id = "bulk-action-selector-bottom")
	WebElement bulkaction_combobottom;
	
	@FindBy(id = "search-submit")
	WebElement searchPost_button;
	
	@FindBy(id = "post-search-input")
	WebElement textToSearchPost;
	
	
	public void NewPostOnclick(){
		New_button.click();
	}
	
	public WebElement bulkaction_combobottom()
	{
		return bulkaction_combobottom ;
	}
	
	public void ApplyButtonOnClick()
	{
		apply_button.click();
	}
	
	public void SearchPostButtonOnclick(){
		searchPost_button.click();
	}
	
	public void set_textToSearchPost(String value){
		textToSearchPost.clear();
		textToSearchPost.sendKeys(value);
	}

}
