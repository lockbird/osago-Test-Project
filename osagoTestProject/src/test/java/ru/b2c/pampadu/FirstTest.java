package ru.b2c.pampadu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class FirstTest extends Data {

    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();
    private By inputValidStateNumber = By.xpath("//div[@class='gos-input-main-container']//input[@class='gos-input-main']");
    private By inputValidRegistrationRegionCode = By.xpath("//div[@class='layout gos-input-region-container column']//input[@class='gos-input-region']");
    private By btnContinue = By.xpath("//div[@class='layout column fill-height justify-center']//button[@class='v-btn v-btn--contained theme--light v-size--default primary']");
    private By labelCorrect = By.xpath("//div[@class='flex ppdw-element xs100 sm50']//label[2]");

    @Test
    public void firstTest() {

        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(inputValidStateNumber).sendKeys(getDate.validStateNumber);
        driver.findElement(inputValidRegistrationRegionCode).sendKeys(getDate.validRegistrationRegionCode);
        driver.findElement(btnContinue).click();
        String getLabelCorrect = driver.findElement(labelCorrect).getText();
        Assert.assertEquals("154.6 кВт", getLabelCorrect);
        driver.quit();
    }
}
