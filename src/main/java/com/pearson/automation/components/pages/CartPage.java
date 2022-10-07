package com.pearson.automation.components.pages;

import com.pearson.automation.components.fragments.CartRowsFragment;
import com.pearson.automation.testBase.AbstractPage;
import com.pearson.automation.testBase.Page;
import com.pearson.automation.utils.FragmentGenerator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.List;

@Lazy
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Page.URL(format = "https://www.pearsonassessments.com/store/usassessments/en/cart/(.*)")
public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='item__description']")
    List<WebElement> cartPageList;

    @FindBy(xpath="//button[@class='button--secondary button--block save__cart--link cart__head--link js-save-cart-link']")
    private WebElement saveCartButton;

    public List<CartRowsFragment> cartRows() {
        FragmentGenerator<CartRowsFragment> generator = new FragmentGenerator<>(CartRowsFragment.class);
        return generator.getFragments(cartPageList);
    }

        public CartRowsFragment getProductByISBNFromCart(String isbn) {
        return cartRows().stream()
                //  .filter(product -> product.getProductNumber().equals(isbn))
                .filter(product -> product.getProductByISBNFromCartFragment().equals(isbn))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Unable to find product with ISBN "+isbn));
    }
    public void DeleteRowFromCart (String isbn){
        getProductByISBNFromCart(isbn).clickOnRemoveProductFromCard();
        getProductByISBNFromCart(isbn).clickOnRemoveProductFromCartButton();
    }

    public boolean checkSaveCartButtonIsEnabled(){
        try {
            saveCartButton.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getQuantityFromProductFromcart(String isbn) {
        return getProductByISBNFromCart(isbn).getProductQuantity();


    }

    public void updateQuantityForAProductFromCart(String isbn,String value) {
        System.out.println(getQuantityFromProductFromcart(isbn));
        getProductByISBNFromCart(isbn).insertQuantity(value);
        System.out.println(getQuantityFromProductFromcart(isbn));
    }
}
