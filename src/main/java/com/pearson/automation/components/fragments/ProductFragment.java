package com.pearson.automation.components.fragments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ProductFragment extends AbstractFragment {
    private static final String BASE_LOCATOR = "//div[@id='products']//li[@class='program-page__item']";

    private static final By BY_XPATH_LOCATOR = By.xpath(BASE_LOCATOR);

    public ProductFragment() {
        super(BY_XPATH_LOCATOR);
    }

    public ProductFragment(WebElement webElement) {
        super(webElement);
    }

    @FindBy(xpath = ".//span[@class='product-number']")
    private WebElement productNumber;


//    @Getter
//    public By xpathProductNumber = By.xpath(".//span[@class='product-number']");

    @FindBy(xpath = ".//button[@data-modal-title='Add to cart']")
    private WebElement addToCartButton;

//    @Getter
//    public By xpathAddToCartButton = By.xpath(".//button[@data-modal-title='Add to cart']");



    public String getProductNumberText() {
        return getWebElement("productNumber").getText();
    }

    public void clickOnAddToCartButton() {
        getWebElement("addToCartButton").click();
    }
}
