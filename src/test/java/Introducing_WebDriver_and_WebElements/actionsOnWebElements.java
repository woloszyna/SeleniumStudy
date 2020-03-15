package Introducing_WebDriver_and_WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class actionsOnWebElements {

    WebDriver driver;

    @BeforeMethod

    public void open() {

        System.setProperty("webdriver.new.driver", "WebDrivers/chromedriverv80");
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test(priority = 0)

    public void sendKeys() {

        //find search-bar
        WebElement searchbar = driver.findElement(By.id("search"));

        //provide string for search
        searchbar.sendKeys("Phones");

        //submit
        searchbar.submit();

        //assert  if the searched is displayed
        Assert.assertEquals("Search results for: 'Phones'", driver.getTitle());
        System.out.println("Page title correct");

    }

    @Test(priority = 1)

    public void clear() throws InterruptedException {

        WebElement searchbar = driver.findElement(By.id("search"));
        searchbar.sendKeys("This is some awful long String");
        Thread.sleep(5000);
        searchbar.clear();
        searchbar.sendKeys("Again, look how it will clear in 5");
        Thread.sleep(1000);
        searchbar.clear();
        searchbar.sendKeys("Again, look how it will clear in 4");
        Thread.sleep(1000);
        searchbar.clear();
        searchbar.sendKeys("Again, look how it will clear in 3");
        Thread.sleep(1000);
        searchbar.clear();
        searchbar.sendKeys("Again, look how it will clear in 2");
        Thread.sleep(1000);
        searchbar.clear();
        searchbar.sendKeys("Again, look how it will clear in 1");
        Thread.sleep(1000);
        searchbar.clear();
        searchbar.sendKeys("BYEEEEEEEE :)");
        Thread.sleep(2000);
        searchbar.clear();
        Thread.sleep(2000);
    }

    @AfterMethod

    public void close() {

        driver.quit();

    }
}
