
package WebGuiTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;

public class Tests extends TestBase{
	@Test
	public void SearchForText() {
				driver.get("https://www.google.com/ncr");
		googleHomepage.searchForText("selenium webdriver");
		List<WebElement> link = driver.findElements(By.xpath("//*[@id='rso']"));
		WebElement thirdLink = (WebElement) link.get(0);
		Assert.assertTrue(thirdLink.getText().contains("What is Selenium WebDriver?"));	 
	}	
	@Test
	public void uploadImage() {	
		driver.get("https://the-internet.herokuapp.com/");
		theInternetHomepage.goToFileUploadPage();
		theInternetFileUploadPage.uploadImage("C:\\Users\\Ahmed Mostafa\\Desktop\\image.png");
		/*Get the image name only without the whole path*/
		File imageName = new File("C:\\Users\\Ahmed Mostafa\\Desktop\\image.png");
		/*Assert that the image is uploaded with the correct name*/
		WebElement uploadedImage = driver.findElement(By.id("uploaded-files"));
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(uploadedImage.isDisplayed());
		sa.assertEquals(uploadedImage.getText(),imageName.getName());
		sa.assertAll();
	}
	@Test
	public void dynamicLoading() {
		driver.get("https://the-internet.herokuapp.com/");
		theInternetHomepage.goTodynamicloadingPage();
		theInternetDynamicLoadingPage.startDynamicLoading();
		/*Assert that the text displayed is "Hello World!" */
		String text = driver.findElement(By.id("finish")).getText();
		Assert.assertTrue(text.contains("Hello World!"));


	}
}