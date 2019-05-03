package defaultPackage;

import static org.junit.Assert.*;


import org.junit.*;
import org.openqa.selenium.WebDriver;
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
	public void RegisterUserTest()
	{
		homePage.clickRegister();
		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.setUsername("asdfghj");
		registerPage.setLastName("ASdfggfds");
		registerPage.setTelephone("123456");
		registerPage.setAddress("asdasdadsds");
		registerPage.setCity("asdadsasdfsdfa");
		registerPage.setPostCode("11300");
		registerPage.setZoneOption();
		registerPage.setPassword("Asdasdads123");
		registerPage.agreeToTerms();
		registerPage.confirm();
		String expectedTitle = "Your Account Has Been Created!";
		String actualTitle = driver.getTitle();

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
