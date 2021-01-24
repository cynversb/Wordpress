package stepDefinition.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.wordpress.Pages.PagesPageEditorBulk;
import com.wordpress.Pages.PostPage;
import com.wordpress.Pages.PostPageDashboard;

import Helper.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinition.LoginAprove;

public class Step_RemovePage {
	private WebDriver driver;
	public PostPageDashboard PageDash;
	public String title;
	public LoginAprove obj;
	public BrowserFactory Objclose;
	public PostPage PageNew;
	public String PageID;
	public PagesPageEditorBulk PageEditB;
	
	@Before
	public void Login() {
		Objclose = new BrowserFactory();
		obj = new LoginAprove();
		driver = obj.login();
		goToScreenPage();
	}
	
	public void goToScreenPage() {
		driver.findElements(By.className("wp-menu-name")).get(3).click();
		PageDash=new PostPageDashboard(driver);
	}
	
  	@Given ("Me encuentro en la pagina principal de Page y selecciono una Page")
	public void selectPostFromTable() {
		//driver.findElement(By.id("cb-select-10")).click();
  		PageID = "cb-select-5";
		driver.findElement(By.id(PageID)).click();
	}
	
	@When("Se da clic en el combobox 'Move to Trash' de Page")
	public void post_selectActionTrash_ComboboxBottom(){
	
		//Select BulkActionBottom = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
		//BulkActionBottom.selectByValue("trash");
		
		WebElement web = PageDash.bulkaction_combobottom();
  		Select BulkActionBottom = new Select(web);
  		BulkActionBottom.selectByValue("trash");
  		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Then("Se elimina la Page seleccionada")
	public void post_selectButonApplyBottom()
	{
		//driver.findElement(By.id("doaction2")).click();
		PageDash.ApplyButtonOnClick();
	}
		
	@After
	 public void tearDown() {
        Objclose.tearDown(driver);
    }
}
