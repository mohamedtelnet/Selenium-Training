package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
	
	
	public WebDriver driver;
	

	public WelcomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//By signin=By.xpath("//span[normalize-space()='Login']");
	By Categorie=By.cssSelector(".c-navigation__link.m-level-1[href='https://www.loreal-paris.fr/maquillage/']");
//	By title=By.cssSelector("div[class='text-center'] h2");
//	By NavBar=By.cssSelector("ul[class*='navbar-nav']");
	public WebElement getCategorie()
	{
		
		return driver.findElement(Categorie);
		
	}

//	public WebElement getTitle()
//	{
//		
//		return driver.findElement(title);
//		
//	}
//	
//	public WebElement getNavigationBar()
//	{
//		
//		return driver.findElement(NavBar);
//		
//	}
}
