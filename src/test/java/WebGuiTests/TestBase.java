package WebGuiTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageModel.GoogleHomepage;
import pageModel.TheInternetDynamicLoadingPage;
import pageModel.TheInternetFileUploadPage;
import pageModel.TheInternetHomepage;

public class TestBase{
	public static GoogleHomepage googleHomepage;
	public static TheInternetHomepage theInternetHomepage;
	public static TheInternetFileUploadPage theInternetFileUploadPage;
	public static TheInternetDynamicLoadingPage theInternetDynamicLoadingPage;
	public static WebDriver driver;
	@BeforeTest
	public void Open_Browser() 
	{
		System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
		driver =new ChromeDriver();
//		driver.navigate().to("https://www.google.com");
		googleHomepage = new GoogleHomepage(driver);
		theInternetHomepage = new TheInternetHomepage(driver);
		theInternetFileUploadPage = new TheInternetFileUploadPage(driver);
		theInternetDynamicLoadingPage = new TheInternetDynamicLoadingPage(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@AfterTest
	public void close_Browser() 
	{
		driver.close();
	}

















}
