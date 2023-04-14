package ru.b2c.pampadu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SecondTest extends Data {

    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();
    private By inputValidStateNumber = By.xpath("//div[@class='gos-input-main-container']//input[@class='gos-input-main']");
    private By inputValidRegistrationRegionCode = By.xpath("//div[@class='layout gos-input-region-container column']//input[@class='gos-input-region']");
    private By btnContinue = By.xpath("//div[@class='layout column fill-height justify-center']//button[@class='v-btn v-btn--contained theme--light v-size--default primary']");
    private By spanCorrect = By.xpath("//div[@class='layout column fill-height justify-center']//span[@class='gos-sign-title']");

    @Test
    public void secondTest() {

        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(inputValidStateNumber).sendKeys(getDate.invalidStateNumber);
        driver.findElement(inputValidRegistrationRegionCode).sendKeys(getDate.invalidRegistrationRegionCode);
        driver.findElement(btnContinue).click();
        String getSpanCorrect = driver.findElement(spanCorrect).getText();
        Assert.assertEquals("Введите гос. номер", getSpanCorrect);
        driver.quit();
    }
}
