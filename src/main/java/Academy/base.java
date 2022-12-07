package Academy;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		//chrome
		
		
		prop=new Properties();

		// to Read all the modification in your File use FileInputStream
		
		FileInputStream fis =new FileInputStream("C:\\Users\\Mohamed.Kharrat\\eclipse-workspace\\C3 Agent_3.17.0.1\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

	System.out.println(prop.getProperty("browser"));

		//System.out.println(prop.getProperty("url"));
		//prop.setProperty("browser", "firefox");
		
		String browserName=prop.getProperty("browser");
		
		/* to write all the modification in your File use FileOutputStream
		
		FileOutputStream fos =new FileOutputStream("C:\\Users\\Mohamed.Kharrat\\eclipse-workspace\\C3 Agent_3.17.0.1\\CoreJava\\src\\data.properties");

		prop.store(fos, null);*/
	if (browserName.equals("chrome"))
	{
		//execute in chrome driver 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohamed.Kharrat\\Desktop\\Mohamed\\Automatisation\\Chrome Driver\\chromedriver.exe");

		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
		
		//options.addArguments("--headless");
	
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver();
         return driver;
		
	}
	else if (browserName.equals("firefox"))
	{
		//execute in firefox driver 
	}
	return driver;
	}
	
	public void getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		 TakesScreenshot ts =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File source=ts.getScreenshotAs(OutputType.FILE);
String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";

System.out.println(destinationFile);
	            //Move image file to new destination

	               // File DestinationFile=new File("C:\\Users\\Mohamed.Kharrat\\test.png");
File DestinationFile=new File(destinationFile);
	                //Copy file at destination 

	              FileUtils.copyFile(source, DestinationFile);
		   	
		
	}
	
}
