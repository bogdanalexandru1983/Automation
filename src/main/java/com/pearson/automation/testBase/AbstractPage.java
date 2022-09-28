package com.pearson.automation.testBase;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.pearson.automation.testBase.WebDriverContainer.getDriver;

public class AbstractPage {
    public void navigate() {
        getDriver().get(getURL());

    }

    public AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitUntilLoaded() {
        PageWaits.waitUntilJQueryLoad();
        PageWaits.waitUntilJsReady();
        waitForUrl();
    }

    public String getURL() {
        return this.getClass().getAnnotation(Page.URL.class).URL();
    }

    public String getFormat() {
        return this.getClass().getAnnotation(Page.URL.class).format();
    }

    public boolean isAccordingUrl() {

        if (StringUtils.isNotEmpty(getFormat())) {
            return WebDriverContainer.getDriver().getCurrentUrl().matches(getFormat());
        } else if (StringUtils.isNotEmpty(getURL())) {
            return WebDriverContainer.getDriver().getCurrentUrl().equals(getURL());
        } else {
            throw new RuntimeException("Page needs either URL or format");
        }

    }


    public void waitForUrl() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(driver -> isAccordingUrl());
    }
    public static boolean waitUntilIsPresent(WebElement element){
        return element!=null;
    }

}
