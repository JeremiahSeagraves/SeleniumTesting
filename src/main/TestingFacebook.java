package main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingFacebook {

	public static void main(String[] args) {
		setOSDriver();
		
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "https://es-la.facebook.com";
		driver.get(baseURL);
		
		WebElement usuario = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		usuario.sendKeys("=");
		
		/**WebElement contrasenia = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		contrasenia.sendKeys("12345");
		**/
		
		usuario.submit();
		
		WebElement myDynamicElement = (new WebDriverWait(driver,10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")));
		myDynamicElement.click();
		
		
		getScreenShot(driver);
		
		
	}
	
	private static void getScreenShot(WebDriver driver){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Python23\\SeleniumTesting\\screenFacebook.png");
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
