package stepDefinition.Post;
 
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.concurrent.TimeUnit;
import java.nio.file.Paths;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


import stepDefinition.LoginAprove;


import com.wordpress.Pages.PostPage;
import com.wordpress.Pages.PostPageDashboard;

import Helper.BrowserFactory;


public class Step_PublishPost{
	private WebDriver driver;
	public PostPageDashboard PostDash;
	public String title;
	public LoginAprove obj;
	public BrowserFactory Objclose;
	public PostPage PostNew;
	
	@Before
	public void Login() {
		Objclose = new BrowserFactory();
		obj = new LoginAprove();
		
		driver = obj.login();
		postHomePage();
	}
	
	@Given("Me encuentro en la pagina 'Add Post'con link")
	public void postHomePage(){
		//		Post.goToPostScreen();
		driver.findElements(By.className("wp-menu-name")).get(1).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostDash = new PostPageDashboard(driver);
		clickOnButtonAddNewPost();
	}
	public void clickOnButtonAddNewPost() {
    	PostDash.NewPostOnclick();
    	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	PostNew = new PostPage(driver);
    }
	
    @When("Se agrega titulo y Se da click en el boton 'Publish'")
    public void AddTitleAndclickOnButtonAddPublish() {
    	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	title = "Hola a todos";
    	PostNew.AddTitlePost(title);
    	PostNew.PublishPostOnclick();

    	//System.out.println("Estoy aqui0");
    	PostNew.PublishPosttListOnclick(1,driver);

    	//System.out.println("Estoy aqui1");
    }
    
    @SuppressWarnings("static-access")
	@Then("Se publica el Post en la Web")
    public void publishPost() {

    	String link_PostAddress;
    	String link_ViewPost;
    	
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	link_PostAddress= PostNew.getLinkPostAddress();
		//driver.findElement(By.className("components-text-control__input")).getAttribute("value");
    	
    	System.out.println(link_PostAddress);		
    	link_ViewPost = driver.findElement(By.className("components-button").className("is-secondary")).getAttribute("href");		
    	System.out.println(link_ViewPost);
    	
    	assertEquals(link_ViewPost,link_PostAddress);
    	driver.findElements(By.className("components-button").className("is-secondary")).get(0).click();		
	 }
    
    @After
    public void tearDown() {
        Objclose.tearDown(driver);
    }
}
	
	