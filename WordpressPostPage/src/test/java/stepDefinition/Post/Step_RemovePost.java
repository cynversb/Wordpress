package stepDefinition.Post;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import stepDefinition.LoginAprove;

import com.wordpress.Pages.PostPage;
import com.wordpress.Pages.PostPageDashboard;

import Helper.BrowserFactory;



public class Step_RemovePost {

	
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
	
	public void postHomePage(){
		driver.findElements(By.className("wp-menu-name")).get(1).click();
		PostDash = new PostPageDashboard(driver);
	}
	
	@Given("Me encuentro en la pagina principal de Post y selecciono un Post")
	public void selectPostFromTable() {
		PostID = "cb-select-14";
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id(PostID)).click();
		//PostDash = new PostPageDashboard(driver);
		//driver.findElement(By.id("cb-select-10")).click();
	}
	
	@When("Se da clic en el combobox 'Move to Trash'")
	public void post_selectActionTrash_ComboboxBottom(){
		//seleccionar un post de la tabla
		//WebElement baseTable = driver.findElement(By.tagName("table"));
		//WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"posts-filter\"]\table\tbody\tr").id("title"));
		
		//Select BulkActionBottom = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
		//BulkActionBottom.selectByValue("trash");
		
		WebElement web = PostDash.bulkaction_combobottom();
  		Select BulkActionBottom = new Select(web);
  		BulkActionBottom.selectByValue("trash");
  		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Then("Se elimina el Post seleccionado")
	public void post_selectButonApplyBottom()
	{
		//driver.findElement(By.id("doaction2")).click();
		PostDash.ApplyButtonOnClick();
	}
		
	@After
	 public void tearDown() {
        Objclose.tearDown(driver);
    }
}
