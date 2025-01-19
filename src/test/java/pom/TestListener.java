package pom;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Ended: " + result.getName());

        setup("chrome"); // or pass the desired browser parameter
        TakesScreenshot screenshot = (TakesScreenshot) webDriverShared.get();
        screenshot.getScreenshotAs(OutputType.FILE).renameTo(new File("C:\\Users\\nipun\\Projects\\QA_Course\\Assignment_02\\src\\test\\java\\resources\\" + result.getName() + ".png"));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        setup("chrome"); // or pass the desired browser parameter
        TakesScreenshot screenshot = (TakesScreenshot) webDriverShared.get();
        screenshot.getScreenshotAs(OutputType.FILE).renameTo(new File("C:\\Users\\nipun\\Projects\\QA_Course\\Assignment_02\\src\\test\\java\\resources\\" + result.getName() + ".png"));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }
}

