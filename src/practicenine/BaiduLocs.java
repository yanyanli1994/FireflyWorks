package practicenine;

public interface BaiduLocs {
	
	String login ="//a[@name='tj_login']";
	String username = "//input[ contains(@placeholder,'�û���')]";
	String password = "//input[ contains(@placeholder,'����') and preceding-sibling::label[text()='����']]";
	
     
	String submit ="//input[@value='��¼' and following-sibling::a[text()='����ע��']]";
     
	String baiduMusic = "//p/a[contains(@href,'music')]";
	
	String dayTopSong = "//div[preceding-sibling::div/a[contains(@href,'dayhot')]]/ul/li[1]/span[3]/a";
	
	String goToDownload = "//span[text()='����']";
	
	String download =  "//a[contains(@href,'link=http')]//span[text()='����']";
}
