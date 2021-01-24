package stepDefinition.Post;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.wordpress.Pages.PostPage;
import com.wordpress.Pages.PostPageDashboard;

import Helper.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinition.LoginAprove;

public class Step_SearchPost {

	private WebDriver driver;
	public PostPageDashboard PostDash;
	public String PostID;
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
	

    @Given("Me encuentro en la pantalla Post")  
	public void postHomePage()
	{
		driver.findElements(By.className("wp-menu-name")).get(1).click();
		PostDash = new PostPageDashboard(driver);
	}
    
    @When("Escribo en el textbox la palabra 'h'")
	public void post_writeTextSearched()
	{
		//driver.findElement(By.id("post-search-input")).sendKeys("hi");
    	PostDash.set_textToSearchPost("hi");
	}
    @Then("Da click en el boton 'Search Post' y la tabla muestra los post buscados")
	public void post_selectButtonSearchPost()
	{
		//driver.findElement(By.id("search-submit")).click();
    	PostDash.SearchPostButtonOnclick();
	}
	
    @After
	 public void tearDown() {
        Objclose.tearDown(driver);
    }
	
}
