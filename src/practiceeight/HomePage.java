package practiceeight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practicefour.Wait;

public class HomePage {
	
	private WebDriver driver;

	
	@FindBy(xpath = "//span[text()='��ҳ']")
	protected WebElement hometab;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;		
		PageFactory .initElements(driver, this);			
	}
	
	
	public void viewHomeTab(){
		Wait wait = new Wait(driver);
		wait.waitForElementPresent("//span[text()='��ҳ']");
		hometab.click();
	}
	
}
