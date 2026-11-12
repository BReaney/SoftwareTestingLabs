package lab05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UVicTest {

    WebDriver browser;

    @BeforeEach
    public void setUp() {
        // Chrome
        //System.setProperty("webdriver.chrome.driver", "/location/of/your/chromedriver");
        browser = new ChromeDriver();

        // Firefox
        // System.setProperty("webdriver.gecko.driver", "*****LOCATION OF YOUR WEBDRIVER*****");
        // browser = new FirefoxDriver();

        // Safari
        // browser = new SafariDriver();

        browser.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    @Test
    public void uvicPageLoads() {
        browser.get("https://www.uvic.ca");
        assertEquals("Home - University of Victoria", browser.getTitle());
    }

    @Test
    public void searchButtonExists(){
        browser.get("https://www.uvic.ca");
        WebElement searchButton = browser.findElement(By.className("icoa--up"));
        assertTrue(searchButton.isEnabled());
    }
    @Test
    public void searchBarAppears(){
        browser.get("https://www.uvic.ca");
        WebElement searchButton = browser.findElement(By.className("icoa--up"));
        searchButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchBar = browser.findElement(By.name("q"));
        assertTrue(searchBar.isEnabled());
    }
    @Test
    public void typingWorks(){
        browser.get("https://www.uvic.ca");
        WebElement searchButton = browser.findElement(By.className("icoa--up"));
        searchButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchBar = browser.findElement(By.name("q"));
        searchBar.sendKeys("csc");
        assertEquals("csc", searchBar.getAttribute("value"));
    }

    @Test
    public void searchingWorksClick() {
        browser.get("https://www.uvic.ca");
        WebElement searchButton = browser.findElement(By.className("icoa--up"));
        searchButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchBar = browser.findElement(By.name("q"));
        WebElement confirm = browser.findElement(By.className("srch__btn"));
        searchBar.sendKeys("csc");
        confirm.click();

        new WebDriverWait(browser, Duration.ofSeconds(15)).until(ExpectedConditions.titleIs("Search - Search - University of Victoria"));
        assertEquals("Search - Search - University of Victoria", browser.getTitle());

    }
    // Your tests go here
    @Test
    public void searchingWorksEnter() {
        browser.get("https://www.uvic.ca");
        WebElement searchButton = browser.findElement(By.className("icoa--up"));
        searchButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchBar = browser.findElement(By.name("q"));
        WebElement confirm = browser.findElement(By.className("srch__btn"));
        searchBar.sendKeys("csc");
        confirm.submit();

        new WebDriverWait(browser, Duration.ofSeconds(15)).until(ExpectedConditions.titleIs("Search - Search - University of Victoria"));
        assertEquals("Search - Search - University of Victoria", browser.getTitle());

    }
    @Test
    public void phoneNumberExists(){
        browser.get("https://www.uvic.ca/ecs/computerscience/index.php");
        WebElement phoneNumber = browser.findElement(By.className("phone"));

        assertEquals("tel:250-472-5700", phoneNumber.getAttribute("href"));
    }
}
