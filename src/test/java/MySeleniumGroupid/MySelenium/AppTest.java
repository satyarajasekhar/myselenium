package MySeleniumGroupid.MySelenium;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver = null;
	String BASE_URL = "http://ec2-13-232-222-250.ap-south-1.compute.amazonaws.com:3001/";
	String userName = "";
	@BeforeClass
	public void prepareChrome() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajassat\\Desktop\\career\\Devops\\selenium\\jars\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		if(driver == null) {
			driver = new ChromeDriver(options);
		}
        userName = "satyarajasekhar"+ (new Random()).nextInt(500);
	}
	@Test
	public void addNewUser() {
		prepareChrome();
		driver.get(BASE_URL+"/add.php");
		driver.findElement(By.name("login")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(userName);
		driver.findElement(By.name("click")).click(); System.out.println("Adding user: "+userName+" to the website");
	}
	@Test
	public void loginNewUser() {
		prepareChrome();
		driver.get(BASE_URL); driver.manage().window().maximize();
		driver.findElement(By.name("login")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(userName);
		driver.findElement(By.name("click")).click();
	}
}
