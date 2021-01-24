package stepDefinition.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import com.wordpress.Pages.PagesPageEditorBulk;
import com.wordpress.Pages.PostPage;
import com.wordpress.Pages.PostPageDashboard;


import Helper.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinition.LoginAprove;

public class Step_EditPage {

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
	
  	@Given ("Me encuentro en la pagina principanl de 'Page' y selecciono un Page")
	public void selectPostFromTable() {
		//driver.findElement(By.id("cb-select-10")).click();
  		PageID = "cb-select-5";
		driver.findElement(By.id(PageID)).click();
	}
  	
  	@And ("Doy clic en la opcion Edit del combo en Page")
	public void post_selectActionEdit_ComboboxBottom(){
		//Select BulkActionBottom = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
		//BulkActionBottom.selectByValue("edit");
  		WebElement web = PageDash.bulkaction_combobottom();
  		Select BulkActionBottom = new Select(web);
  		BulkActionBottom.selectByValue("edit");
	}
  	
  	@When ("Se da clic en Apply y muestra la pantalla BULK EDIT PAGE") 
	public void post_selectButonApplyBottom(){
		//driver.findElement(By.id("doaction2")).click();
		PageDash.ApplyButtonOnClick();
		PageEditB=new PagesPageEditorBulk(driver);
	}
  	 
    @And ("Se edita las opciones Author,Comments,Pings y Status de page")
	public void post_edit(){
		//Select page_AuthorCmbx = new Select(driver.findElement(By.className("authors")));
		//page_AuthorCmbx.selectByValue("1");
		
		PageEditB.seleccionarAuthor_Page("1");
		
		//Select page_ParentsCmbx = new Select(driver.findElement(By.id("post_parent")));
		//page_ParentsCmbx.selectByValue("0");
		PageEditB.seleccionarPostparent_Page("0");
		
		//Select page_CommentsCmbx = new Select(driver.findElement(By.name("comment_status")));
		//page_CommentsCmbx.selectByValue("open");
		PageEditB.seleccionarCommentStatus_Page("open");
		
		//Select page_StatusCmbx = new Select(driver.findElement(By.name("_status")));
		//page_StatusCmbx.selectByValue("draft");
		PageEditB.seleccionarStatus_Page("draft");
		
	}
    @Then ("Se da clic en el boton Update y la Page es actualizada")
	public void post_selectButonUpdateEdit()
	{
		//driver.findElement(By.id("bulk_edit")).click();
    	PageEditB.confirmarEditOnClick();
	}
	
	@After
	 public void tearDown() {
        Objclose.tearDown(driver);
    }
}
