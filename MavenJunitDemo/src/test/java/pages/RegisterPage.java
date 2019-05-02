package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    By usernameInput = By.id("input-firstname");
    By lastnameInput = By.id("input-lastname");
    By emailInput = By.id("input-email");
    By telephoneInput = By.id("input-telephone");
    By addressInput = By.id("input-address-1");
    By cityInput = By.id("input-city");
    By postcodeInput = By.id("input-postcode");
    By zoneInput = By.id("input-zone");//despues hacer lo ed label
    By passwordInput = By.id("input-password");
    By confirmInput = By.id("input-confirm");
    By agreeButton = By.name("agree");//hay que clickear esto
    By registerButton = By.cssSelector(".btn-primary");

    
}