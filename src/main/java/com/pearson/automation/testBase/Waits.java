package com.pearson.automation.testBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.pearson.automation.testBase.WebDriverContainer.getDriver;

public class Waits {

    public static WebDriverWait getWaitObject() {
        return new WebDriverWait(getDriver(), Duration.ofMillis(10000));
    }

    public static void getImplicitWaitObject(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void waitUntilIsVisible(WebElement element) {
        getWaitObject().until(ExpectedConditions.visibilityOf(element));

    }

    public static boolean waitUntilIsPresent(WebElement element){
        return element!=null;
    }

    public static void waitUntilIsClickable(WebElement element){
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }
}
