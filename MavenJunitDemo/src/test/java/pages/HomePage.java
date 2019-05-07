package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By myAccountButton = By.cssSelector("#top-links > ul > li.dropdown > a > i");
    By registerButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");
    By loginButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a");
    By searchBar = By.xpath("//input[@value='search']");
    By searchButton = By.cssSelector("#search > span > button > i");
    By searchResult = By.cssSelector('#content > div:nth-child(8) > div > div > div.image > a > img');
    
    public HomePage(WebDriver webDriver)
    {
        driver = webDriver;
    }

    public void clickRegister()
    {    	
        driver.findElement(myAccountButton).click();
        driver.findElement(registerButton).click();
    }

    public void clickLogin()
    {
        driver.findElement(myAccountButton).click();
        driver.findElement(loginButton).click();
    }
    
    public void search(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void selectFirstSearchResult() {
        driver.findElement(searchResult).click();
    }
}