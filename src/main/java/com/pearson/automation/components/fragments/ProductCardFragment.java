package com.pearson.automation.components.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ProductCardFragment extends AbstractFragment {
    private static final String BASE_LOCATOR = "//ul[@class='preferred-format']/li";

    private static final By BY_XPATH_LOCATOR = By.xpath(BASE_LOCATOR);

    public ProductCardFragment() {
        super(BY_XPATH_LOCATOR);
    }

    public ProductCardFragment(WebElement webElement) {
        super(webElement);
    }

    @FindBy(xpath = ".//button[@class='preferred-format__button']")
    private WebElement cardTypeButton;


    public void clickOnCard() {
       getWebElement("cardTypeButton").click();
       //cardTypeButton.click();
    }
}
