package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class validateTitlecucumber extends base {
 
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(base.class.getName());	
	
	
	@Given("I open the browser")
  public void I_open_the_browser() throws IOException {
 
	  driver = initializeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));	
		log.info("Helloooooooooooooooooooooooooooo");
  }

  @When("I check the value")
  public void I_check_the_value() {
		// To access a Method of a class there is 2 way: Inheritance or creating object
		// to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		// compare the text from the browser with actual value-> Error if there is any mismatch
		assertEquals(l.getTitle().getText(), "FEATURED COURSES");
  
  }

  @Then("I validate the message")
  public void I_validate_the_message() {
	  
	  driver.close();		
  }
}
