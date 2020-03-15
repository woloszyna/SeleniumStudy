package Introducing_WebDriver_and_WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class openWebpage {

    WebDriver driver;

    @BeforeMethod
    public void open() {

        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriverv80");

        driver = new ChromeDriver();
        driver.get("https://betestautomation.azurewebsites.net/");
    }


    @Test(priority = 0)
    public void verifycorrectpage() {

        //assert if on the page
        Assert.assertEquals(driver.getTitle(), ("Home Page - SimplCommerce"));

    }

    @Test(priority = 1)
    public void topBar() throws InterruptedException {

        WebElement cookieconsent = driver.findElement(By.id("cookieConsent"));
        WebElement accept = driver.findElement(By.xpath("//*[@id=\"cookieConsent\"]/div/div/div/button"));
        WebElement logo = driver.findElement(By.linkText("SimplCommerce"));
        WebElement searchbar = driver.findElement(By.id("Query"));
        WebElement dropdownElement = driver.findElement(By.id("Category"));
        WebElement searchbutton = driver.findElement(By.className("search-btn"));
        WebElement shoppingcart = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/a/i"));

        Select dropdown = new Select(dropdownElement);


        Assert.assertEquals(true, cookieconsent.isDisplayed());
        accept.click();
        Assert.assertEquals(true, logo.isDisplayed());
        Assert.assertEquals(true, searchbar.isDisplayed());
        Assert.assertEquals(true, dropdownElement.isDisplayed());

        //assert options in the dropdown
        dropdown.selectByValue("all");
        String all = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(all, "All Categories");
        //Thread.sleep(1000);


        dropdown.selectByValue("woman");
        String woman = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(woman, "Woman");
        //Thread.sleep(1000);

        dropdown.selectByValue("man");
        String man = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(man, "Man");
        //Thread.sleep(1000);


        dropdown.selectByValue("shoes");
        String shoes = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(shoes, "Shoes");
        //Thread.sleep(1000);


        dropdown.selectByValue("watches");
        String watches = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(watches, "Watches");
        //Thread.sleep(1000);

        Assert.assertEquals(true, searchbutton.isDisplayed());
        Assert.assertEquals(true, shoppingcart.isDisplayed());

    }

    @AfterMethod
    public void close() {

        driver.quit();

    }
}


