package defaultPackage;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Test;

public class SampleTest {
	java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
	
	@Test
	public void simpleTest() {
		int a = 1;
		int b = 2;
		assertTrue(a + b == 3);
	}

	@Test
	public void sampleSeleniumHTMLDriverTest()
	{
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();

		assertEquals(expectedTitle, actualTitle);
	}
}
