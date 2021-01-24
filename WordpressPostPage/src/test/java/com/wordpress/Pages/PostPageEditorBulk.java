package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PostPageEditorBulk {

	WebDriver driver;
	
	public PostPageEditorBulk(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(className = "authors")
	WebElement authors_Post;
	
	@FindBy(name = "comment_status")
	WebElement CommentStatus_Post;
	
	@FindBy(name = "ping_status")
	WebElement pingStatus_Post ;
	
	@FindBy(name = "_status")
	WebElement status_Post;
	
	@FindBy(id = "bulk_edit")
	WebElement confirmEdit_Button;
	
	public void set_authors(String value){
		authors_Post.clear();
		authors_Post.sendKeys(value);
	}
	public void set_CommentStatusPost(String value){
		CommentStatus_Post.clear();
		CommentStatus_Post.sendKeys(value);
	}
	public void set_pingStatus_Post(String value){
		pingStatus_Post.clear();
		pingStatus_Post.sendKeys(value);
	}
	public void status_Post(String value){
		status_Post.clear();
		status_Post.sendKeys(value);
	}

	public void seleccionarAuthor(String value)
	{	
		Select post_AuthorCmbx = new Select(authors_Post);
		post_AuthorCmbx.selectByValue(value);
	}
	
	public void seleccionarCommentStatusPost(String value)
	{	
		Select post_AuthorCmbx = new Select(CommentStatus_Post);
		post_AuthorCmbx.selectByValue(value);
	}
	public void seleccionarPingStatus_Post(String value)
	{	
		Select post_AuthorCmbx = new Select(pingStatus_Post);
		post_AuthorCmbx.selectByValue(value);
	}
	
	public void seleccionarStatus_Post(String value)
	{	
		Select post_AuthorCmbx = new Select(status_Post);
		post_AuthorCmbx.selectByValue(value);
	}
	
	public void confirmarEditOnClick(){
		
		confirmEdit_Button.click();
	}
}
