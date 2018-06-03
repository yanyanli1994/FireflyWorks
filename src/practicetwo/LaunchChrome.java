package practicetwo;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class LaunchChrome {
	
	private WebDriver chromewb = null;
	private DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void startChrome(){
		System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe"); 
		caps = DesiredCapabilities.chrome();
		caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));  //���browser
		caps.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //���ô���
		chromewb = new ChromeDriver(caps);
	}
	
	
	
	@Test
	public void searchOnBaidu(){		
		chromewb.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void releaseChromeDriver(){
		chromewb.quit();
	}
	
}