package main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestingGoogle {

	public static void main(String[] args) throws IOException {
		setOSDriver();
		
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "http://www.google.com.mx";
		driver.get(baseURL);
		
		WebElement we = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
		we.sendKeys("conisoft");
		
		/**JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('lst-ib').setAttribute('value', 'hola mundo')");
		**/
		
		we.submit();
		
		WebElement linkConisoft = driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a"));
		linkConisoft.click();
		
		WebElement myDynamicElement = (new WebDriverWait(driver,10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"myTopnav\"]/li[3]/a")));
		myDynamicElement.click();
		
		
		getScreenShot(driver);
		
	}
	
	private static void getScreenShot(WebDriver driver){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Python23\\SeleniumTesting\\screen2.png");
		try {
			FileUtils.copyFile(scrFile,destFile );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private static void setOSDriver(){
		if(System.getProperty("os.name").startsWith("Win")){
			System.getProperty("webdriver.chrome.driver","chromedriver.exe");
		}else{
			System.getProperty("webdriver.chrome.driver","chromedriver");
		}
	}
	
}