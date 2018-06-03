package practiceseven.pages;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.Wait;
import practiceseven.libs.*;

public class RegisterOnJD {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='regName']")
	private WebElement accountname;
	
	@FindBys(@FindBy(xpath = "//input[@id='pwd']|//input[@id='pwdRepeat']"))
	private List<WebElement> passwds;
	
	@FindBy(xpath="//input[@id='registsubmit']")
	private WebElement submit;
	
	//����Ͳ���Ҫ@FindBy����@FindBys
	protected String dynamicstr;
    protected WebElement regfinished;
	
	public RegisterOnJD(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setAccountName(String accountname){
		this.accountname.sendKeys(accountname);
		setWebElement(accountname);
	}
	
	public void setPassword(String password){
        for(WebElement passwd:passwds){
        	passwd.sendKeys(password);
        }
			
	}
	
	
	public void submit(){		
		submit.click();		
	}
	
	
	//��̬����webpage�ϵ�Ԫ��xpath
	public String setWebElement(String value){
		dynamicstr = "//div[text()=' ��ϲ��%var% ��ע��ɹ���']";
		dynamicstr = dynamicstr.replace("%var%", value);		
		return dynamicstr;
		
	}
	
	public WebElement getWebElement(){		
		regfinished = driver.findElement(By.xpath(dynamicstr));
		return regfinished;
	}
	
}
