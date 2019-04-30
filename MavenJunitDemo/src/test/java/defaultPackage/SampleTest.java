package defaultPackage;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Test;

public class SampleTest {
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
		driver.get("http://opencart.abstracta.us");
		String expectedTitle = "Your Store";
		String actualTitle = driver.getTitle();

		assertEquals(expectedTitle, actualTitle);
	}
}
