package BasicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSamplePrg {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().deleteAllCookies();
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		String pagetitle =driver.getTitle();
		System.out.println(pagetitle);
		//String pagesource=driver.getPageSource();
		//System.out.println(pagesource);
		WebElement messgeField=driver.findElement(By.id("single-input-field"));
		WebElement showButton=driver.findElement(By.id("single-input-field"));
		WebElement message=driver.findElement(By.id("message one"));
		WebElement ValueA=driver.findElement(By.id("value-a"));
		WebElement ValueB=driver.findElement(By.id("value-b"));
		WebElement getTotalButton=driver.findElement(By.id("button-two"));
		WebElement totalMessage=driver.findElement(By.id("message-2"));
		
		messgeField.sendKeys("selenium test");
		showButton.click();
		String mymessage=message.getText();
		System.out.println(mymessage);
		ValueA.sendKeys("100");
		ValueB.sendKeys("100");
		getTotalButton.click();
		String totalMessageText=totalMessage.getText();
		System.out.println(totalMessageText);
		
		//driver.close();
		
}
}
