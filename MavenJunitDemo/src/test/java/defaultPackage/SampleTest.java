package defaultPackage;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Test;
import pages.*;

public class SampleTest {
	private WebDriver driver;
	private HomePage homePage;

	@Before
	public void setUp()
	{
		driver = new HtmlUnitDriver();
		driver.get("http://opencart.abstracta.us");	
		homePage = new HomePage();
		//RegisterPage registerPage = new RegisterPage();
	}

	@Test
	public void sampleSeleniumHTMLDriverTest()
	{
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://opencart.abstracta.us");
		String expectedTitle = "Your Store";
		String actualTitle = driver.getTitle();

		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void sampleChangePOMTest()
	{
		homePage.clickRegister();
		//aca cambie de pagina
		String expectedTitle = "Register Account";

		assertEquals(driver.getTitle(), expectedTitle);
	}
}
