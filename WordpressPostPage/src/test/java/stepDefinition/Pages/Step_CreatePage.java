package stepDefinition.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.wordpress.Pages.PostPage;
import com.wordpress.Pages.PostPageDashboard;
import com.wordpress.Pages.PostPageEditorBulk;

import Helper.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinition.LoginAprove;

public class Step_CreatePage {
	
	private WebDriver driver;
	public PostPageDashboard PageDash;
	public String title;
	public LoginAprove obj;
	public BrowserFactory Objclose;
	public PostPage PageNew;
	public String PageID;
	public PostPageEditorBulk PageEditB;
	
	@Before
	public void Login() {
		Objclose = new BrowserFactory();
		obj = new LoginAprove();
		driver = obj.login();
		goToScreenPage();
	}
		    
	@Given("Me encuentro en la pagina principanl de 'Page'")
	public void goToScreenPage() {
		driver.findElements(By.className("wp-menu-name")).get(3).click();
		PageDash=new PostPageDashboard(driver);
	}
	
	@And("Se da click en el boton 'Add New' para crear una pagina")  
	public void clickOnButtonAddPage(){
		//driver.findElement(By.className("page-title-action")).click();
		PageDash.NewPostOnclick();
		PageNew = new PostPage(driver);
	}
	
	@When("Se agrega titulo de 'Page'")
	public void addPageTitle()
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//driver.findElement(By.id("post-title-0")).sendKeys("Informacion");
		title = "Informacion";
		PageNew.AddTitlePost(title);
	}
	
	@Then("Se da click en el boton 'Publish' y se publica una 'Page'")
	public void clickOnButtonPublishPost()
	{
		//driver.findElement(By.className("editor-post-publish-button__button")).click();
		PageNew.PublishPostOnclick();
		//driver.findElements(By.className("editor-post-publish-button__button")).get(1).click();
		PageNew.PublishPosttListOnclick(1,driver);
	}
	
	@After
	public void tearDown() {
        Objclose.tearDown(driver);
    }

}
