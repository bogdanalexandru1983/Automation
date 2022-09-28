package com.pearson.automation.components.fragments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class StoreModalFragment extends AbstractFragment {

    private static final String BASE_LOCATOR = "//a[contains(@class, 'choose-location-link')]/ancestor::div[@class='pop-up'] | //div[@class='pop-up']";
    private static final By BY_XPATH_LOCATOR = By.xpath(BASE_LOCATOR);

    public StoreModalFragment() {
        super(BY_XPATH_LOCATOR);
    }

    public StoreModalFragment(WebElement webElement) {
        super(webElement);
    }

    @FindBy(xpath = BASE_LOCATOR + "//button[@class='pop-up-close']")
    private WebElement closeButton;

    public void clickOnCloseButton() {
        closeButton.click();
    }
}