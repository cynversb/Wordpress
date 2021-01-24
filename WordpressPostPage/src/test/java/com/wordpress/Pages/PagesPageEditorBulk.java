package com.wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PagesPageEditorBulk {
	

	WebDriver driver;
	
	public PagesPageEditorBulk(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(className = "authors")
	WebElement authors_Page;
	
	@FindBy(name = "comment_status")
	WebElement CommentStatus_Page;
	
	@FindBy(name = "post_parent")
	WebElement postparent_Page ;
	
	@FindBy(name = "_status")
	WebElement status_Page;
	
	@FindBy(id = "bulk_edit")
	WebElement confirmEdit_Button;
	
	public void set_authors_Page(String value){
		authors_Page.clear();
		authors_Page.sendKeys(value);
	}
	public void set_CommentStatus_Page(String value){
		CommentStatus_Page.clear();
		CommentStatus_Page.sendKeys(value);
	}
	public void set_postparent_Page(String value){
		postparent_Page.clear();
		postparent_Page.sendKeys(value);
	}
	public void status_Page(String value){
		status_Page.clear();
		status_Page.sendKeys(value);
	}

	public void seleccionarAuthor_Page(String value)
	{	
		Select page_AuthorCmbx = new Select(authors_Page);
		page_AuthorCmbx.selectByValue(value);
	}
	
	public void seleccionarCommentStatus_Page(String value)
	{	
		Select page_CommentStatusCmbx = new Select(CommentStatus_Page);
		page_CommentStatusCmbx.selectByValue(value);
	}
	public void seleccionarPostparent_Page(String value)
	{	
		Select page_postparentCmbx = new Select(postparent_Page);
		page_postparentCmbx.selectByValue(value);
	}
	
	public void seleccionarStatus_Page(String value)
	{	
		Select page_StatusPageCmbx = new Select(status_Page);
		page_StatusPageCmbx.selectByValue(value);
	}
	
	public void confirmarEditOnClick(){
		confirmEdit_Button.click();
	}

}
