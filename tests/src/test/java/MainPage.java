import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class MainPage extends PageBase {

    private By body = By.tagName("body");
    private By mainPageIcon = By.xpath("//*[@id=\"body\"]/header/div/div/a");
    private By contactLink = By.xpath("//*[@id=\"body\"]/footer/nav/div/nav[3]/ul/li[2]/a");
    private By sigInButton = By.xpath("//*[@id=\"body\"]/header/div[1]/div/a[3]");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://euronics.hu/");
    }

    public String getBodyText() {
        return this.waitAndReturnElement(body).getText();
    }

    public String testCheckCartAfterLogin() {
        return this.waitAndReturnElement(By.xpath("//*[@id=\"cart\"]/div/div[2]/div[2]/div[1]/header")).getText();
    }

    public LoginPage login() {
        this.waitAndReturnElement(sigInButton).click();

        // this.driver.get("https://euronics.hu/belepes");
        return new LoginPage(this.driver);
    }

    public String testSuccessAfterFormSubmission() {
        return this.waitAndReturnElement(By.className("alert-success")).getText();
    }

    public ContactPage sendFormWithUser() {
        this.driver.get("https://euronics.hu/ugyfelszolgalat");

        return new ContactPage(this.driver);
    }

    public TradeCredit checkTradeCredit() {
        this.driver.get("https://euronics.hu/belepes");
        return new TradeCredit(this.driver);
    }

    public SearchBar searchForPhone() {
        return new SearchBar(this.driver);
    }

    public LogOut logout() {
        this.waitAndReturnElement(By.xpath("//*[@id=\"body\"]/header/div[1]/div/div[1]/a/div")).click();
        this.waitAndReturnElement(By.xpath("//*[@id=\"body\"]/header/div[1]/div/div[1]/div/a[9]")).click();

        return new LogOut(this.driver);
    }

    public String testHeader(){
        return this.waitAndReturnElement(By.xpath("//*[@id=\"contentAfter\"]/div[4]/div[1]")).getText();
    }
}
