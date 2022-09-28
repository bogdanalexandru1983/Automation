package com.pearson.automation.stepDefinitions.pages;

import com.pearson.automation.components.pages.ProgramPage;
import com.pearson.automation.testBase.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramPageStepDefs {
    @Autowired
    ProgramPage programPage;

    @Then("^Program Page: Customer is redirected to the product page for (.*)$")
    public void customer_is_redirected_to_the_product_page(String product) {
        programPage.waitUntilLoaded();
        String url = programPage.getURL();
        Assertions.assertTrue(programPage.isRedirectedToProductPage(product), "Customer was not redirected to the product page");
    }

    @And("^Program Page: Customer click on '(.*)' card type$")
    public void customer_click_on_format_card(String cardType) {
        programPage.clickOnCardType(cardType);
    }

    @Then("^Program Page: Customer click on Add to cart button for product '(.*)'$")
    public void customerClickOnAddToCartButtonForProduct(String isbn) {
        //  programPage.getProductByISBN(isbn).clickOnAddToCartButton();
        programPage.clickOnproduct(isbn);
    }

    @Then("small cart page is opened")
    public void smallCartPageIsOpened() {
        programPage.waitUntilSmallCartPageIsOpened();
    }

    @And("Customer click on view cart")
    public void customerClickOnViewCart() {
        programPage.clickOnViewCart();
    }
}
