package stepDefinition.Post;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

public class Step_EditarPost {

	private WebDriver driver;
	public PostPageDashboard PostDash;
	public String title;
	public LoginAprove obj;
	public BrowserFactory Objclose;
	public PostPage PostNew;
	public String PostID;
	public PostPageEditorBulk PostEditB;
	
	@Before
	public void Login() {
		Objclose = new BrowserFactory();
		obj = new LoginAprove();
		driver = obj.login();
		postHomePage();
	}
	public void postHomePage(){
		driver.findElements(By.className("wp-menu-name")).get(1).click();
		//selectPostFromTable();
	}
	
  	@Given ("Me encuentro en la pagina Post y selecciono un post")
	public void selectPostFromTable() {
  		PostID = "cb-select-12";
		driver.findElement(By.id(PostID)).click();
		
		PostDash = new PostPageDashboard(driver);
	}
  	@And ("Doy clic en la opcion Edit del combo")
	public void post_selectActionEdit_ComboboxBottom(){
		//Select BulkActionBottom = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
  		WebElement web = PostDash.bulkaction_combobottom();
  		Select BulkActionBottom = new Select(web);
  		BulkActionBottom.selectByValue("edit");
	}
  	@When ("Se da clic en Apply y muestra la pantalla BULK EDIT") 
	public void post_selectButonApplyBottom(){
		//driver.findElement(By.id("doaction2")).click();
  		 PostDash.ApplyButtonOnClick();
	}
    @And ("Se edita las opciones Author,Comments,Pings y Status del post")
	public void post_edit(){
    	PostEditB = new PostPageEditorBulk(driver);
    	
		//Select post_AuthorCmbx = new Select(driver.findElement(By.className("authors")));
    	//    	post_AuthorCmbx.selectByValue("1");
		PostEditB.seleccionarAuthor("1");
    	
		//Select post_CommentsCmbx = new Select(driver.findElement(By.name("comment_status")));
		//post_CommentsCmbx.selectByValue("open");
		PostEditB.seleccionarCommentStatusPost("open");
		
		//Select post_PingCmbx = new Select(driver.findElement(By.name("ping_status")));
		//post_PingCmbx.selectByValue("open");
		PostEditB.seleccionarPingStatus_Post("open");
		
		//Select post_StatusCmbx = new Select(driver.findElement(By.name("_status")));
		//post_StatusCmbx.selectByValue("publish");
		PostEditB.seleccionarStatus_Post("publish");
		
	}
    @Then ("Se da clic en el boton Update y el post es actualizado.")
	public void post_selectButonUpdateEdit()
	{
		//driver.findElement(By.id("bulk_edit")).click();
    	PostEditB.confirmarEditOnClick();
	}
	
	@After
    public void tearDown() {
        Objclose.tearDown(driver);
    }
}
