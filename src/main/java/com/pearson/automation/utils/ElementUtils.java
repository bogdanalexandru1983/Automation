package com.pearson.automation.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.pearson.automation.testBase.PageWaits.getWaitObject;

public class ElementUtils {

    public static void waitUntilIsVisible(WebElement element) {
        getWaitObject().until(ExpectedConditions.visibilityOf(element));

    }
}
