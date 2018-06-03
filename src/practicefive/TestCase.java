package practicefive;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import practicefour.Wait;
import practicefour.homework.Do;

public class TestCase implements Locators{

	private WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	private Wait wait = null;
	
	@BeforeClass
	public void startFirefox(){
		File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
	    File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
		firefoxprofile =  new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			ffwb = new FirefoxDriver(firefoxprofile);
			wait = new Wait(ffwb);
			ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ffwb.manage().window().maximize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	@Test
	public void changeiFrame(){		
		ffwb.get("http://jqueryui.com/slider/");
		wait.waitForElementPresent(JQUERYHOME);
		ffwb.switchTo().frame(ffwb.findElement(By.xpath(SLIDERIFRAME)));
		Point initialPoint= ffwb.findElement(By.xpath(SLIDER)).getLocation();
		System.out.println(initialPoint);
       
        Actions dragger = new Actions(ffwb);
        dragger.dragAndDropBy(ffwb.findElement(By.xpath(SLIDER)), initialPoint.getX()+569, initialPoint.getY()).build().perform();
        initialPoint= ffwb.findElement(By.xpath(SLIDER)).getLocation();
        System.out.println(initialPoint);
        wait.waitFor(5000);

		
		
		ffwb.switchTo().defaultContent();
		ffwb.findElement(By.xpath(DRAGGABLE)).click();
		wait.waitFor(3000);

	}
	
	
	@Test
	public void selectItemFromDropDownList(){
		//��¼jd�ٷ���վ
		ffwb.get("http://www.jd.com");
		wait.waitForElementPresent("//a[text()='[��¼]']");
		ffwb.findElement(By.xpath("//a[text()='[��¼]']")).click();		
		//��¼�û���Ϣ
		wait.waitForElementPresent("//input[@id='loginname']");
		ffwb.findElement(By.xpath("//input[@id='loginname']")).sendKeys("test201301@mailinator.com");
		ffwb.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("admin123");
		ffwb.findElement(By.xpath("//input[@id='loginsubmit']")).click();
		//��¼������Ϣ
		ffwb.findElement(By.xpath("//a[text()='�ҵĶ���']")).click();
		ffwb.findElement(By.xpath("//a[text()='�˻���Ϣ']")).click();	
		//ѡ���Ϻ���Ϊ����province
		Select province = new Select(ffwb.findElement(By.xpath("//select[@id='province']")));
		province.selectByVisibleText("�Ϻ�");
		wait.waitFor(3000);
		//��ӡ�Ϻ��µ���������
		Select city = new Select(ffwb.findElement(By.xpath("//select[@id='city']")));
		List<WebElement> allcitys = city.getOptions();
		for(WebElement eachcity:allcitys)
			System.out.println(eachcity.getText());
		
	}
	
	
	@Test
	public void changeWindows(){
		ffwb.get("http://www.baidu.com");
		ffwb.findElement(By.xpath("//input[@id='kw1']")).sendKeys("oracle",Keys.ENTER);
		//ffwb.findElement(By.xpath("//input[@id='kw1']")).submit();
		ffwb.findElement(By.xpath("//a[following-sibling::a[contains(text(),'����')]]/em[contains(text(),'Oracle')]")).click();
		Switch switchW = new Switch(ffwb);
		switchW.toSpecificWindow("Oracle | Hardware and Software, Engineered to Work Together");
		ffwb.findElement(By.xpath("//h3[text()='Downloads']")).click();
		
		switchW.toSpecificWindow("oracle_�ٶ�����");
		ffwb.findElement(By.xpath("//input[@id='kw']")).clear();
		ffwb.findElement(By.xpath("//input[@id='kw']")).sendKeys("eclipse");		
		wait.waitFor(5000);
	}
	
	
	@Test
	public void mouseRightclickContext(){
		ffwb.get("http://www.126.com/");		
		ffwb.findElement(By.xpath("//input[@id='idInput']")).clear();
		ffwb.findElement(By.xpath("//input[@id='idInput']")).sendKeys("FireflyAutomation");
		ffwb.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly");
		ffwb.findElement(By.xpath("//button[@id='loginBtn']")).click();			
		wait.waitFor(5000);
		Actions actions = new Actions(ffwb);
		actions.contextClick(ffwb.findElement(By.xpath("//div/span[text()='�ռ���']"))).build().perform();
		wait.waitFor(2000);
		ffwb.findElement(By.xpath("//div[contains(@id,'mail_menu')][last()]/descendant::span[text()='��']")).click();
		wait.waitFor(2000);
		Assert.assertEquals(ffwb.findElement(By.xpath("//header[@class='frame-main-cont-head']/descendant::span[text()='�� ��']")).isDisplayed(), true);
		
		
		
	}
	
	
	
	 @Test
	    public void dragAndDrop(){
	        ffwb.get("http://yixun.com");
	        Point shanghai = ffwb.findElement(By.xpath("//h2[contains(text(),'3F')]")).getLocation();
	        System.out.print(shanghai);
	        ((JavascriptExecutor) ffwb).executeScript("window.scrollBy("+shanghai.getX()+","+shanghai.getY()+")");
	        wait.waitFor(5000);     
	    }
	     

	
		
	
	@AfterClass
	public void releaseFFDriver(){
		ffwb.quit();
	}
}
