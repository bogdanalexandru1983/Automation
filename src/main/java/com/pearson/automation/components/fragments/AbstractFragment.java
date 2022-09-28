package com.pearson.automation.components.fragments;

import com.pearson.automation.testBase.WebDriverContainer;
import com.pearson.automation.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.util.List;

import static com.pearson.automation.testBase.WebDriverContainer.getDriver;

public class AbstractFragment implements WebElement {

    protected WebElement webElement;

    public AbstractFragment(By byLocator) {
        PageFactory.initElements(getDriver(), this);
        webElement = getDriver().findElement(byLocator);
    }

    public AbstractFragment(WebElement webElement) {
        PageFactory.initElements(getDriver(), this);
        this.webElement = webElement;
    }

    private By getBy(String fieldName) {
        try {
            return new Annotations(this.getClass().getDeclaredField(fieldName)).buildBy();
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException(e);
        }
    }

    public WebElement getWebElement(String fieldName) {
        return this.findElement(getBy(fieldName));
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText().trim();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public void waitUntilIsVisible() {
        ElementUtils.waitUntilIsVisible(webElement);
    }
}