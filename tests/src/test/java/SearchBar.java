import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchBar extends PageBase {
    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void login() {
        By searchLocator = By.xpath("//*[@id=\"search_type_searchText1\"]");
        By searchButton = By.xpath("//*[@id=\"search_type\"]/div[2]/button");
        this.waitAndReturnElement(searchLocator).sendKeys("iphone");
        this.waitAndReturnElement(searchButton).click();
    }
}
