package Introducing_WebDriver_and_WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class gettingWebElementsProperties {

    WebDriver driver;

    @BeforeMethod
    public void open() {

        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriverv80");
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");

    }

    @Test(priority = 0)
    public void getAttributes() {

        //find element
        WebElement searchbar = driver.findElement(By.name("q"));

        //getAttribute (e.g. class names, etc.) of particular element
        System.out.println("Class of the box is " + searchbar.getAttribute("Class"));

    }

    @Test(priority = 1)
    public void getText() {

        //getText method brings back
        //find element
        WebElement siteNotice = driver.findElement(By.className("global-site-notice"));

        //getText() from particular element
        System.out.println("The text on the element is " + siteNotice.getText());
    }

    @Test(priority = 2)
    public void getCssValue() {

        //find element
        WebElement account = driver.findElement(By.className("label"));

        //Get CSS from the element
        System.out.println("the CSS of the element is " + account.getCssValue("font-family"));

    }

    @Test(priority = 3)
    public void getLocation() {

        //find element
        WebElement logo = driver.findElement(By.className("large"));

        //Check where the element is located on the page
        System.out.println("The element is located: (x, y): " + logo.getLocation() + ".");
    }

    @Test(priority = 4)
    public void getSize() {

        //find element
        WebElement logo = driver.findElement(By.className("large"));

        //check size of the element
        System.out.println("Size of the element is " + logo.getSize());
    }

    @Test(priority = 5)
    public void getTagName() {

        //find element with the tag
        WebElement searchbar = driver.findElement(By.id("search_mini_form"));

        System.out.println("tagName of the element is: " + searchbar.getTagName());

    }



    @AfterMethod
    public void close() {

        driver.quit();

    }


}
