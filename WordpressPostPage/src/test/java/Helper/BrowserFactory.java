package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	
	public static WebDriver startBrowser(String browserName,String url){
		WebDriver driver = null;
		if(browserName.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	
		return driver;
	}
	
	 public void tearDown(WebDriver driver) {
	        if (driver!=null) {
	            driver.close();
	            System.out.println("Se cerro el buscador");
	            //driver.quit();
	            //driver = null;
	        }
	  }
}
