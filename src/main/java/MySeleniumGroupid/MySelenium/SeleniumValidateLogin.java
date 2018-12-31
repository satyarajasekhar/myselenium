package MySeleniumGroupid.MySelenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumValidateLogin {
	WebDriver driver = null;
	String BASE_URL = "http://ec2-35-154-15-249.ap-south-1.compute.amazonaws.com:3001";
	String userName = "satyarajasekhar"+ (new Random()).nextInt(500);
	@BeforeClass
	public void prepareChrome() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajassat\\Desktop\\career\\Devops\\selenium\\jars"
				//+ "\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
	}
	@Test
	public void addNewUser() {
		driver.get(BASE_URL+"/add.php");
		driver.findElement(By.name("login")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(userName);
		driver.findElement(By.name("click")).click(); System.out.println("Adding user: "+userName+" to the website");
	}
	@Test
	public void loginNewUser() {
		driver.get(BASE_URL); driver.manage().window().maximize();
		driver.findElement(By.name("login")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(userName);
		driver.findElement(By.name("click")).click();
	}
    public static void main( String[] args ) throws InterruptedException
    {
    	SeleniumValidateLogin app = new SeleniumValidateLogin();
		app.prepareChrome(); app.addNewUser(); app.loginNewUser(); 
    }


}
