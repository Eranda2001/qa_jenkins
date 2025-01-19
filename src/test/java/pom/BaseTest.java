package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

    protected static ThreadLocal<WebDriver> webDriverShared = new ThreadLocal<>();

    @BeforeSuite
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")) webDriverShared.set(new ChromeDriver());
        else if (browser.equalsIgnoreCase("firefox")) webDriverShared.set(new FirefoxDriver());
        else if (browser.equalsIgnoreCase("edge")) webDriverShared.set(new ChromeDriver());

        webDriverShared.get().manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        webDriverShared.get().quit();
    }

}
