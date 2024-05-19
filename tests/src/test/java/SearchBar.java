import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
