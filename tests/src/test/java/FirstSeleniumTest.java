import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import java.util.*;

import java.net.URL;
import java.net.MalformedURLException;

public class FirstSeleniumTest {
    public WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        /* ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize(); */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", "../chromedriver-win64/chromedriver.exe");
        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @Test
    public void testHeader(){
        //As the website does NOT have a title I tested the first available text in the main tag
        MainPage mainPage = new MainPage(this.driver);

        Assert.assertTrue(mainPage.testHeader().contains("Téged is érdekelhet"));
    }

    @Test
    public void login() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.login();
        loginPage.login();

         Assert.assertTrue(mainPage.getBodyText().contains("Rendelésed összegzése"));
    }

    @Test
    public void submitFormWithLoggedInUser() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.login();
        loginPage.login();

        ContactPage contactPage = mainPage.sendFormWithUser();
        contactPage.sendContactForm();

        Assert.assertTrue(mainPage.getBodyText().contains("Köszönjük"));
    }

    @Test
    public void testTradeCreditPage() {
        MainPage mainPage = new MainPage(this.driver);
        TradeCredit tradeCredit = mainPage.checkTradeCredit();
        Assert.assertTrue(mainPage.getBodyText().contains("Részletvásárlási lehetőség az Euronics-nál"));
    }

    @Test
    public void testSearchBar() {
        MainPage mainPage = new MainPage(this.driver);
        SearchBar searchBar = mainPage.searchForPhone();
        Assert.assertTrue(mainPage.getBodyText().contains("Keresés: "));
    }

    @Test
    public void logout() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.login();
        loginPage.login();

        Assert.assertTrue(mainPage.getBodyText().contains("Bejelentkezés"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
