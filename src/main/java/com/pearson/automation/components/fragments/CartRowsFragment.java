package com.pearson.automation.components.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class CartRowsFragment extends AbstractFragment{
    private static final String BASE_LOCATOR = "//div[@class='item__description']";

    private static final By BY_XPATH_LOCATOR = By.xpath(BASE_LOCATOR);

    public CartRowsFragment() {super(BY_XPATH_LOCATOR);}//ca sa unim xpathurile sa iasa xpatul absolut

    public CartRowsFragment(WebElement webElement) {
        super(webElement);
    }

    @FindBy(xpath = ".//div[@class='item__code no-phone']")
    private WebElement ISBN;

    @FindBy(xpath = ".//div[@class='quals-badge']")
    private WebElement qualification;

    @FindBy(xpath = ".//div[@class='item__quantity']//input[contains(@class,'js-update-entry-quantity-input')]")
    private  WebElement quantity;

    @FindBy(xpath = ".//div[not(contains(@class,'item__quantity__total hidden'))]//div[@class='item__total js-item-total']")
    private WebElement priceTotal;

    @FindBy(xpath = ".//button[@class='btn btn-default js-cartItemDetailBtn']")
    private WebElement deleteButton;

    @FindBy(xpath=".//a[@class='js-track-removecartitem']")
    private WebElement deleteNewButton;

    public String getProductByISBNFromCartFragment() {
        return getWebElement("ISBN").getText();
    }

    public void clickOnRemoveProductFromCard() {
        getWebElement("deleteButton").click();
    }

    public void clickOnRemoveProductFromCartButton() {
        getWebElement("deleteNewButton").click();
    }



    public  int getProductQuantity() {
        return Integer.parseInt(getWebElement("quantity").getAttribute("value"));
    }

    public  void insertQuantity(String value) {
        getWebElement("quantity").clear();
        getWebElement("quantity").sendKeys(value);
        getWebElement("quantity").sendKeys(Keys.ENTER);
    }




}
