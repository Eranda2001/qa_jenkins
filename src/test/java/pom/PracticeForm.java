package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PracticeForm extends BaseTest {

    @Test
    public void formSubmission() {

        JavascriptExecutor executor = (JavascriptExecutor) webDriverShared.get();

        webDriverShared.get().get("https://demoqa.com/automation-practice-form");

        webDriverShared.get().findElement(By.xpath("//input[@placeholder='First Name']"))
                .sendKeys("Nipun");

        webDriverShared.get().findElement(By.xpath("//input[@placeholder='Last Name']"))
                .sendKeys("Bathiya");

        webDriverShared.get().findElement(By.xpath("//input[@placeholder='name@example.com']"))
                .sendKeys("nipun@gmail.com");

        WebElement gender = webDriverShared.get().findElement(By.xpath("//label[@for='gender-radio-1']"));
        executor.executeScript("arguments[0].click()", gender);

        webDriverShared.get().findElement(By.xpath("//input[@placeholder='Mobile Number']"))
                .sendKeys("0712719315");

        webDriverShared.get().findElement(By.xpath("//input[@id='dateOfBirthInput']"))
                .sendKeys("01/01/2001");

        WebElement hobby = webDriverShared.get().findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        executor.executeScript("arguments[0].click()", hobby);

        webDriverShared.get().findElement(By.xpath("//textarea[@placeholder='Current Address']"))
                .sendKeys("Colombo, Sri Lanka");

        WebElement submitButton = webDriverShared.get().findElement(By.xpath("//button[@id='submit']"));
        executor.executeScript("arguments[0].click();", submitButton);

        if(webDriverShared.get().findElement(By.xpath("//div[@class='modal-body']")).isDisplayed()) {
            System.out.println("Form submitted successfully");
        } else {
            System.out.println("Form submission failed");
        }

    }

    @Test(dependsOnMethods = "formSubmission")
    public void WidgetInteraction() {
        System.out.println("Widget Interaction Implementation");
    }
}
