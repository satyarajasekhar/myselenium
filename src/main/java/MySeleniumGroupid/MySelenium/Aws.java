package MySeleniumGroupid.MySelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class Aws
{
	WebDriver driver = null;
	@BeforeClass
	public void prepareChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajassat\\Desktop\\career\\Devops\\selenium\\jars\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println( "Chrome Driver ready!" );
	}
	
	@Test
	public void fetchAwsSummaryDetails() throws InterruptedException {
		//driver.get("https://aws.amazon.com/");
		driver.get("https://aws.amazon.com/products/?hp=tile&so-exp=below");
		driver.manage().window().maximize();
		//StringBuffer sb = new StringBuffer(driver.getPageSource());
		List<WebElement> headerList = driver.findElements(By.className("lb-item-wrapper"));
		
		for (int i = 0; i < headerList.size(); i++) {
			System.out.println("===================================================");
			WebElement webElement = headerList.get(i);
			System.out.println(i+"."+webElement.getText());
			System.out.println("------------------");
			//BELOW LINE WILL SCROLL THE SCREEN TO THE PLACE WHERE ELEMENT IS FOUND.
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
			Thread.sleep(500); 
			/*List<WebElement> subElements = webElement.findElements(By.className("lb-content-item"));
			if(subElements != null && subElements.size() > 0) {
				System.out.println("ITEMS FOUND...");
			}*/
		}
		// ALL SERVICES IN AWS
		List<WebElement> subElements = driver.findElements(By.xpath("//div[@class='lb-content-item']"));
		for (int j = 0; j < subElements.size(); j++) {
			WebElement subElement = subElements.get(j);
			//driver.findElementByXPath("//span/span");
			String innerText = subElement.findElement(By.tagName("a")).getAttribute("innerText");
			String spanText = subElement.findElement(By.cssSelector("span")).getAttribute("innerText");
			//String innerText = subElement.findElement(By.tagName("a")).getText();
			String url = subElement.findElement(By.tagName("a")).getAttribute("href");
			System.out.println(j+" " + innerText + " --> " + spanText+" --> "+ url);
		}
		System.out.println("===================================================");
/*		List<WebElement> detailsList = driver.findElements(By.xpath("//div[@class=lb-item-expander-content]/div[@class=lb-content-item]/a"));
		for (WebElement webElement1 : detailsList) {
			System.out.println(webElement1.getText());
		}*/
		/*System.out.println("===================================================");
		List<WebElement> divList = driver.findElements(By.className("lb-content-item")); //driver.findElements(By.xpath("//div[@class=lb-content-item]"));
		for (WebElement webElement2 : divList) {
			String innerText = webElement2.findElement(By.tagName("a")).getAttribute("innerText");
			String url = webElement2.findElement(By.tagName("a")).getAttribute("href");
			System.out.println(innerText + "--> " + url);
		}
*/		
		
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
		Aws app = new Aws();
		app.prepareChrome();
		app.fetchAwsSummaryDetails();
    }
}
