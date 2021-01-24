package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.Pages.LoginPage;

import Helper.BrowserFactory;


public class LoginAprove {

	private static String PageUrl="https://s1.demo.opensourcecms.com/wordpress/wp-login.php";
	
	
	public WebDriver login() {
		WebDriver driver = BrowserFactory.startBrowser("chrome", PageUrl);
		LoginPage loginPagWeb = PageFactory.initElements(driver, LoginPage.class);
		loginPagWeb.login_Wordpress("opensourcecms", "opensourcecms");
		return driver;
	}
	
}
