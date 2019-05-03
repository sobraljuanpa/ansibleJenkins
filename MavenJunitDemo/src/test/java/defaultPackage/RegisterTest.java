package defaultPackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert.*;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

import pages.*;

@RunWith(Parameterized.class)
public class RegisterTest {

    private WebDriver driver;
    private HomePage homePage;
    private String prueba1;
    private String prueba2;

    @Parameterized.Parameters
    public static Collection inputData() {
        return Arrays.asList(new Object[][] {
            { "prueba1", "algo" },
            { "prueba2", "algo" }
        });
    }

    @Before
    public void setUp(){
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver","/home/juanpa/drivers/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Simulo ingreso a la homepage
        driver.get("http://opencart.abstracta.us");
        homePage = new HomePage(driver);
    }

    public RegisterTest(String p1, String p2) {
        this.prueba1 = p1;
        this.prueba2 = p2;
    }

    @Test
    public void testParameterizedRuns() {
        Assert.assertEquals(prueba1, prueba2);
    }
}