package Using_Java_8_Featurs_with_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Stream {

    WebDriver driver;

    @BeforeMethod
    public void open() {
        System.setProperty("webdriver.new.chromedriver", "WebDriver/chromedriverv80");
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");

    }

    @Test(priority = 0)

    public void stream() {

        List<String> languages = new ArrayList<String>();
        languages.add("English");
        languages.add("German");
        languages.add("French");

        for (String language : languages) {
            System.out.println(language);
        }
        System.out.println("");

        languages.stream().forEach(System.out::println);
    }

    @AfterMethod
    public void close() {

        driver.quit();
    }
}
