package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(base.class.getName());	
	@BeforeTest
	public void initialize() throws IOException
	
	{
		driver = initializeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			log.info("Driver is initialized");
		
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username,String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		// To access a Method of a class there is 2 way: Inheritance or creating object
		// to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		lp.getLogin().click();

	}
// Data provider vous permet de changer les input du TC when running TCs	
	@DataProvider
	
public Object[][] getData()

{
		// Row stands for how many diffrent data types test should run
		// Coloumn stands for how many values per each test 
		
	Object[][] data=new Object[2][2];
		//0th Row
	
	data[0][0]="nonrestricteduser@gmail.com";
	data[0][1]="123456";
	//data[0][2]="Restricted user";
	
	// 1st Row
	
	data[1][0]="restricteduser@gmail.com";
	data[1][1]="123456";
	//data[1][2]="Non Restricted user";
	
	return data;
}
	
@AfterTest
	
	private void teardown() {
driver.close();		
}
	

}