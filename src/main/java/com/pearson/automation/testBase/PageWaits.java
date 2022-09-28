package com.pearson.automation.testBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.pearson.automation.testBase.WebDriverContainer.getDriver;


public class PageWaits {
    public static WebDriverWait getWaitObject() {

        return new WebDriverWait(getDriver(), Duration.ofMillis(10000));
    }


    public static void waitUntilJsReady() {
        getWaitObject().until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitUntilJQueryLoad() {
        getWaitObject().until(driver -> jQueryAJAXCallsHaveCompleted());
    }

    private static ExpectedCondition<Boolean> jQueryAJAXCallsHaveCompleted() {
        return driver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
    }

}
