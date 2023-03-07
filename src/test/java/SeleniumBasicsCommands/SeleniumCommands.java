package SeleniumBasicsCommands;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommands {
	public WebDriver driver;

	public void testInitialise(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			try {
				throw new Exception("Invalid browser");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
@BeforeMethod
public void setUp() {
	testInitialise("chrome");
}
@AfterMethod
public void tearDown() {
	//driver.close();
}
@Test
public void TC_001_verifyObsquaraTitle()
{
	driver.get("https://selenium.obsquara.com/index.php");
	String actualTitle=driver.getTitle();
	System.out.println(actualTitle);
	String expectedTitle="Obsqura Testing";
	Assert.assertEquals(actualTitle,expectedTitle,"Invalid Title Found");
}

@Test
public void TC_002_verifySingleFieldMessage() {
	driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	WebElement messageField=driver.findElement(By.id("single-input-field"));
	WebElement showButton=driver.findElement(By.id("button-one"));
	WebElement message=driver.findElement(By.id("message-one"));
	messageField.sendKeys("data");
	showButton.click();
	String actualMessage=message.getText();
	System.out.println(actualMessage);
	String expectedMessage="Your Message:data";
	System.out.println(expectedMessage);
	Assert.assertEquals(actualMessage,expectedMessage,"Invalid Title Found");
}
@Test
public void TC_003_verifyTwoInputFieldMessage()
{
	driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	WebElement valueA=driver.findElement(By.id("value-a"));
	WebElement valueB=driver.findElement(By.id("value-b"));
	WebElement getTotalButton=driver.findElement(By.id("button-two"));
	WebElement totalMessage=driver.findElement(By.id("message-two"));
	 valueA.sendKeys("2");
	 valueB.sendKeys("4");
	 getTotalButton.click();
	 String actualTotal=totalMessage.getText();
		System.out.println(totalMessage);
		String expectedTotal="Total A+B:6";
		Assert.assertEquals(actualTotal,expectedTotal,"Invalid Total Message Found");
}
@Test
public void TC_004_verifyLocators()throws InterruptedException
{
	driver.get("https://demowebshop.tricentis.com/register");
	WebElement firstName=driver.findElement(By.id("FirstName"));
	WebElement lastName=driver.findElement(By.id("LastNameb"));
	WebElement email=driver.findElement(By.id("Email"));
	WebElement password=driver.findElement(By.id("Password"));
	WebElement confirmPassword=driver.findElement(By.id("ConfirmPassword"));
	WebElement registerButton=driver.findElement(By.id("register-button"));
	firstName.sendKeys("Pranav");
	lastName.sendKeys("M K");
	email.sendKeys("pranavmk777@gmail.com");
	password.sendKeys("test@123");
	confirmPassword.sendKeys("test@123");
	registerButton.click();
	Thread.sleep(3000);
	WebElement resultText=driver.findElement(By.className("result"));
	String actualText=resultText.getText();
	System.out.println(actualText);
	String expectedText="Your registration completed";
	Assert.assertEquals(actualText,expectedText,"Invalid Text Found");	
}
@Test
public void TC_005_verifyDemoShopLoginPage()
{
	driver.get("https://demowebshop.tricentis.com");	
	WebElement loginLink=driver.findElement(By.className("ico-login"));
	loginLink.click();
	WebElement emailField=driver.findElement(By.className("Email"));
	WebElement password=driver.findElement(By.className("Password"));
	emailField.sendKeys("pranavmk777@gmail.com");
	 password.sendKeys("test@123");
	 WebElement loginButton=driver.findElement(By.cssSelector("body>div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main >"));
	 loginButton.click();
}
@Test
public void TC_006_verifyEmptyFieldValidation()
{
	driver.get("https://selenium.obsqurazone.com/form-submit.php");
	WebElement submitFormButton=driver.findElement(By.xpath("//button[text()='Submit form']"));
	submitFormButton.click();
	
	WebElement firstNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom01']//following-sibiling::div[1]"));
	String actualFirstNameValidation=firstNameValidation.getText();
	System.out.println(actualFirstNameValidation);
	String expectedFirstNameValidation="Please Enter First Name";
	Assert.assertEquals(actualFirstNameValidation,expectedFirstNameValidation,"Invalid Field Found");
	
	WebElement lastNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom02']//following-sibiling::div[1]"));
	String actualLastNameValidation=lastNameValidation.getText();
	System.out.println(actualLastNameValidation);
	String expectedLastNameValidation="Please Enter Last Name";
	Assert.assertEquals(actualLastNameValidation,expectedLastNameValidation,"Invalid Field Found");
	
	WebElement userNameValidation=driver.findElement(By.xpath("//input[@id='validationCustomUsername']//following-sibiling::div[1]"));
	String actualUserNameValidation=userNameValidation.getText();
	System.out.println(actualUserNameValidation);
	String expectedUserNameValidation="Please choose a UserName";
	Assert.assertEquals(actualUserNameValidation,expectedUserNameValidation,"Invalid Field Found");
	
	WebElement cityNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom03']//following-sibiling::div[1]"));
	String actualCityNameValidation=cityNameValidation.getText();
	System.out.println(actualCityNameValidation);
	String expectedCityNameValidation="Please Enter valid city";
	Assert.assertEquals(actualCityNameValidation,expectedCityNameValidation,"Invalid Field Found");
	
	WebElement stateNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom04']//following-sibiling::div[1]"));
	String actualStateNameValidation=stateNameValidation.getText();
	System.out.println(actualStateNameValidation);
	String expectedStateNameValidation="Please Enter valid city";
	Assert.assertEquals(actualStateNameValidation,expectedStateNameValidation,"Invalid Field Found");
	
	WebElement zipNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom05']//following-sibiling::div[1]"));
	String actualZipNameValidation=zipNameValidation.getText();
	System.out.println(actualCityNameValidation);
	String expectedZipNameValidation="Please Enter valid city";
	Assert.assertEquals(actualZipNameValidation,expectedZipNameValidation,"Invalid Field Found");
}
@Test
public void TC_007_verifyEmptyStateandSitCode()  {
	driver.get("https://selenium.obsqurazone.com/form-submit.php");
	WebElement firstNameField=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
	WebElement lasteField=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
	WebElement userNameField=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
	WebElement cityNameField=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
	WebElement submitButton=driver.findElement(By.xpath("//button[text()='Submit form']"));
	WebElement checkBoxField=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
	
	
	firstNameField.sendKeys("test");
	lasteField.sendKeys("NAmee");
	userNameField.sendKeys("test@gmail.com");
	cityNameField.sendKeys("xxxx");
	checkBoxField.click();
	submitButton.click();
	WebElement stateNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom04']//following-sibling::div[@class='invalid-feedback']"));
	WebElement zipNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom05']//following-sibling::div[@class='invalid-feedback']"));
	
	String actualStateNameValidation=stateNameValidation.getText();
	System.out.println(actualStateNameValidation);
	String expectedStateNameValidation="Please Enter valid city";
	
	String actualZipNameValidation=zipNameValidation.getText();
	System.out.println(actualZipNameValidation);
	String expectedZipNameValidation="Please Enter valid city";
	
	Assert.assertEquals(actualStateNameValidation,expectedStateNameValidation,"Invalid Field Found");
	Assert.assertEquals(actualZipNameValidation,expectedZipNameValidation,"Invalid Field Found");
}
@Test
public void TC_007_verifyFormSubmition()  {
	driver.get("https://selenium.obsqurazone.com/form-submit.php");
	WebElement firstNameField=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
	WebElement lasteField=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
	WebElement userNameField=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
	WebElement cityNameField=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
	WebElement submitButton=driver.findElement(By.xpath("//button[text()='Submit form']"));
	WebElement checkBoxField=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
	WebElement stateNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
	WebElement zipNameValidation=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
	
	
	firstNameField.sendKeys("test");
	lasteField.sendKeys("NAmee");
	userNameField.sendKeys("test@gmail.com");
	cityNameField.sendKeys("xxxx");
	stateNameValidation.sendKeys("RRR");
	zipNameValidation.sendKeys("QWEER");
	checkBoxField.click();
	submitButton.click();
}
@Test
public  void TC_008_verifyLetterSubcribtionUsingCssSelector() {
	driver.get("https://demowebshop.tricentis.com)");
	WebElement emailField=driver.findElement(By.cssSelector("input#newsletter-email"));
	WebElement subcribeButton=driver.findElement(By.cssSelector("input#newsletter-subscribe-button"));
	emailField.sendKeys("pranav111@gmail.com");
	subcribeButton.click();
}
@Test
public  void TC_010_verifyNavigateTo() {
	driver.navigate().to("https://demowebshop.tricentis.com)");
}
@Test
public  void TC_011_verifyRefresh() {
	driver.get("https://demowebshop.tricentis.com)");
	WebElement emailField=driver.findElement(By.xpath("//input@id='newsletter-email']"));
	emailField.sendKeys("pranav111@gmail.com");
	driver.navigate().refresh();
}
@Test
public  void TC_012_verifyForwardAndBackwardNavigation() throws InterruptedException {
	driver.get("https://demowebshop.tricentis.com)");
	WebElement loginLink=driver.findElement(By.xpath("//a[text()='Log in']"));
	loginLink.click();
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
}
@Test
public  void TC_013_verifyWebElementCommands() throws InterruptedException {
	driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
	WebElement subjectField =driver.findElement(By.xpath("//input[@id='subject']"));
	WebElement descriptionField =driver.findElement(By.xpath("//textarea[@id='description']"));
	WebElement submitButton =driver.findElement(By.xpath("//input[@class='btn btn-primary']"));

	subjectField.sendKeys("Selenium");
	descriptionField.sendKeys("Automation Testing");
	subjectField.clear();
	String classAttributeValue=subjectField.getAttribute("class");
	System.out.println("text----------"+ classAttributeValue);
	String tagNameValue=subjectField.getTagName();
	System.out.println("text----------"+ tagNameValue);
	subjectField.sendKeys("Selenium Testing");
	submitButton.click();
	Thread.sleep(3000);
	WebElement validationMessage =driver.findElement(By.xpath("//div[@id='message-one']"));
	String actualValidationMessage=validationMessage.getText();
	String expectedValidationMessage="Form has been submitted successfully!";
	Assert.assertEquals(actualValidationMessage,expectedValidationMessage,"Invalid message");
}
@Test
public void TC_016_verifyIsDisplayed() {
	driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
	WebElement subjectField =driver.findElement(By.xpath("//input[@id='subject']"));
	subjectField.sendKeys("Selenium");
	boolean status=subjectField.isDisplayed();
	System.out.println(status);
	Assert.assertTrue(status,"subject field is not displayed");
}
@Test
public void TC_017_verifyIsSelected() {
	driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
	WebElement singleDemoCheckBox =driver.findElement(By.xpath("//input[@id='gridCheck']"));
	singleDemoCheckBox.sendKeys("Selenium");
	boolean statusBeforeClick= singleDemoCheckBox.isSelected();
	System.out.println("status---------"+statusBeforeClick);
	Assert.assertFalse(statusBeforeClick,"Checkbox is Checked");
	boolean statusAfterClick= singleDemoCheckBox.isSelected();
	System.out.println("status---------"+statusAfterClick);
	Assert.assertTrue(statusAfterClick,"Checkbox is not Checked");
}
@Test
public void TC_017_verifyIsEnabled() {
	driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
	WebElement submitButton =driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	//submitButton.click();
	boolean status=submitButton.isEnabled();
	System.out.println("status------"+status);
	Assert.assertTrue(status,"Form has been submitted successfully!");
	Point point=submitButton.getLocation();
	 System.out.println(point.x +","+ point.y);
	 Dimension dim=submitButton.getSize();
	 System.out.println(dim.height +","+ dim.width);
	 String backGroundColor=submitButton.getCssValue("background-color");
	 System.out.println(backGroundColor);
	 WebElement inputElement =driver.findElement(By.tagName("input"));
	 System.out.println(inputElement);
	 List<WebElement> elements=driver.findElements(By.tagName("input"));
	 System.out.println(elements);
	 submitButton.submit();
}
}
