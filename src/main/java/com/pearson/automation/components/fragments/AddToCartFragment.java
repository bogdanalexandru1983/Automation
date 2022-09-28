package com.pearson.automation.components.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class AddToCartFragment extends AbstractFragment {
    private static final String BASE_LOCATOR = "//div[@id='cboxContent']";

    private static final By BY_XPATH_LOCATOR = By.xpath(BASE_LOCATOR);

    public AddToCartFragment() {
        super(BY_XPATH_LOCATOR);
    }

    public AddToCartFragment(WebElement webElement) {
        super(webElement);
    }

    @FindBy(xpath = ".//a[contains(@class,'add-to-cart-button')]")
    private WebElement viewCart;

    @FindBy(xpath = ".//button[contains(@class,'js-mini-cart-close-button')]")
    private WebElement closeCartAndContinueShopping;

    public void clickOnViewCart() {
        getWebElement("viewCart").click();
        //viewCart.click();
    }

    public void clickOnCloseCartAndContinueShopping() {
        getWebElement("closeCartAndContinueShopping").click();
        //closeCartAndContinueShopping.click();
    }
}
