import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        By emailLocator = By.id("username");
        By passwordLocator = By.id("password");
        By loginButtonLocator = By.className("btn-primary");
        this.waitAndReturnElement(emailLocator).sendKeys("vagoblanka5@gmail.com");
        this.waitAndReturnElement(passwordLocator).sendKeys("SeleniumTest2024");
        this.waitAndReturnElement(loginButtonLocator).click();
    }
}
