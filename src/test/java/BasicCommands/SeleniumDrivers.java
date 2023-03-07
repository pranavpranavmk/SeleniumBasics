package BasicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumDrivers {

	public static void main(String[] args) {
		WebDriver driver;
//		driver=new ChromeDriver();
//		driver.get("https://demowebshop.tricentis.com/");
//		driver.close();
		driver=new EdgeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();
	}

}
