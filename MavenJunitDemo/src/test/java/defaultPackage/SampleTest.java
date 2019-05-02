package defaultPackage;

import static org.junit.Assert.*;


import org.junit.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.firefox.*;
import org.junit.Test;
import pages.*;

public class SampleTest {

	
	private WebDriver driver;
	private HomePage homePage;

	@Before
	public void setUp()
	{
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		System.setProperty("webdriver.gecko.driver","/home/juanpa/drivers/geckodriver");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		driver = new FirefoxDriver(firefoxOptions);
		driver.get("http://opencart.abstracta.us");	
		homePage = new HomePage(driver);
		//RegisterPage registerPage = new RegisterPage();
	}

	@Test
	public void sampleSeleniumHTMLDriverTest()
	{
		driver.get("http://opencart.abstracta.us");
		String expectedTitle = "Your Store";
		String actualTitle = driver.getTitle();
		driver.quit();

		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void sampleChangePOMTest()
	{
		driver.get("http://opencart.abstracta.us");
		homePage.clickRegister();
		//aca cambie de pagina
		String expectedTitle = "Register Account";
		String actualTitle = driver.getTitle();

		assertEquals(actualTitle, expectedTitle);
	}
}
