package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By myAccountButton = By.cssSelector("#top-links > ul > li.dropdown > a > i");
    
    

    public HomePage(WebDriver webDriver)
    {
        driver = webDriver;
    }

    public void clickRegister()
    {    	
        driver.findElement(myAccountButton).click();
        By registerButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");
        driver.findElement(registerButton).click();
    }

    public void clickLogin()
    {
        driver.findElement(myAccountButton).click();
        By loginButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a");
        driver.findElement(loginButton).click();
    }
}