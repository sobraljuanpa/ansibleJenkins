package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By myAccountButton = By.cssSelector("#top-links > ul > li.dropdown > a > i");
    By registerButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");
    By loginButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a");
    By searchBar = By.cssSelector("#search > input");
    By searchButton = By.cssSelector("#search > span > button > i");
    By searchResult = By.cssSelector("#content > div:nth-child(8) > div > div > div.image > a > img");
    By addButton = By.cssSelector("#content > div:nth-child(1) > div.col-sm-4 > div.btn-group > button:nth-child(1)");
    By successPopup = By.cssSelector("body > div:nth-child(4) > div.alert.alert-success");

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

    public void addToWishlist() {
        driver.findElement(addButton).click();
    }

    public bool addedConfirmed() {
        return driver.findElement(successPopup).isVisible();
    }
    
}