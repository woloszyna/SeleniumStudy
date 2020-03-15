package Introducing_WebDriver_and_WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkingWebElementState {

    WebDriver driver;

    @BeforeMethod
    public void open() {

        System.setProperty("webdriver.new.chromedriver", "WebDrivers/chromedriverv80");
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");


    }

    @Test(priority = 0)
    public void isDisplayed() {

        //this method verifies whether the element is displayed on the page

        //find an element
        WebElement searchbar = driver.findElement(By.id("search"));

        //Verify if element is displayedwith the use of boolean flag
        System.out.println("The search box is displayed: " + searchbar.isDisplayed());
    }

    @Test(priority = 1)
    public void isEnabled() {

        //this method verifies if the element is enabled and can be operated with

        //find an element
        WebElement searchbar = driver.findElement(By.id("search"));

        //verify if element is enabled
        System.out.println("The searchbar is enabled: " + searchbar.isEnabled());

    }

    @Test(priority = 2)
    public void isSelected() throws InterruptedException {

        //this method verifies if the element is selected
        //HINT: for this test another page  is required
        driver.get("http://demo-store.seleniumacademy.com/customer/account/create/");

        //find an element
        WebElement checkbox = driver.findElement(By.id("is_subscribed"));

        //verify if element is selected
        System.out.println("The searchbar is selected: " + checkbox.isSelected());

        checkbox.click();

        System.out.println("The searchbar is selected: " + checkbox.isSelected());
        Thread.sleep(2000);


    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}
