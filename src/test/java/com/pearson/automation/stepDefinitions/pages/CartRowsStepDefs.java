package com.pearson.automation.stepDefinitions.pages;

import com.pearson.automation.components.pages.CartPage;
import com.pearson.automation.components.pages.ProgramPage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class CartRowsStepDefs {

    @Autowired
    CartPage cartPage;

    @And("^Cart Page: Customer click delete product '(.*)' from cart$")
    public void customer_detele_product_from_cart(String isbn) {
        cartPage.DeleteRowFromCart(isbn);
    }

    @And("^Cart Page: Check save cart button is enabled$")
    public void check_saved_cart_button_is_enabled() {
    cartPage.checkSaveCartButtonIsEnabled();
}

    @And("^Cart Page: Update quantity for product '(.*)' with value '(.*)'$")
    public void update_quantity_for_product(String isbn,String value) {
        cartPage.updateQuantityForAProductFromCart(isbn, value);
    }
}
