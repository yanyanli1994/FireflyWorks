package practicenine.newpractice_3;

public interface Locators {

	
	String classicMusic = "//a[text()='�����ϸ�']";
	String DownloadIcon = "//li[1]/descendant::span/a[@title='����']";
	String DownloadLink = "//a[contains(@class,'actived')][1]/span/span[contains(text(),'����')]";
	
	String UserName = "//div[@id='J-username']/input";
	String Login = "//div[@id='J-submit']/input";
	String Music = "//p/a[contains(@href,'music')]";
	
}
