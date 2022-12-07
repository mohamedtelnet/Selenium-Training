package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class validateNavigationBar extends base {
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(base.class.getName());	
	@BeforeTest
	public void initialize() throws IOException
	
	{
		driver = initializeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));	
		log.info("Helloooooooooooooooooooooooooooo1111111111");
		
	}	
	
	@Test
	public void baseTitle() throws IOException {
		
		// To access a Method of a class there is 2 way: Inheritance or creating object
		// to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		// compare the text from the browser with actual value-> Error if there is any mismatch
		Assert.assertTrue(l.getNavigationBar().isDisplayed());		

	}

@AfterTest
	
	private void teardown() {
driver.close();		
}
	
}