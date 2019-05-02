package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    WebDriver driver;
    By myAccountButton = By.cssSelector("#top-links > ul > li.dropdown > a > i");
    By registerButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul
     > li:nth-child(1) > a");
    By loginButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul
     > li:nth-child(2) > a");

    public void clickRegister()
    {
        driver.findElement(myAccountButton).click();
        driver.findElement(registerButton).click();
    }

    public void clickLogin()
    {
        driver.findElement(loginButton).click();
    }
}