package com.pearson.automation.components.pages;

import com.pearson.automation.components.fragments.AddToCartFragment;
import com.pearson.automation.components.fragments.ProductCardFragment;
import com.pearson.automation.components.fragments.ProductFragment;
import com.pearson.automation.testBase.AbstractPage;
import com.pearson.automation.testBase.Page;
import com.pearson.automation.testBase.Waits;
import com.pearson.automation.utils.FragmentGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.pearson.automation.testBase.WebDriverContainer.getDriver;
import static java.lang.String.format;

@Lazy
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Page.URL(format = "https://www.pearsonassessments.com/store/usassessments/en/Store/(.*)")

public class ProgramPage extends AbstractPage {
    @FindBy(xpath = "//ul[@class='preferred-format']/li")
    List<WebElement> cardTypeList;

    @FindBy(xpath = "//div[@id='products']//ul[@class='program-page__products']/li")
    List<WebElement> productList;

    @FindBy(xpath = "//div[@id='cboxContent']")
    List<WebElement> addToCartList;


    public List<ProductFragment> getProducts() {
        FragmentGenerator<ProductFragment> generator = new FragmentGenerator<>(ProductFragment.class);
        return generator.getFragments(productList);
    }

    public List<ProductCardFragment> getCardList() {
        FragmentGenerator<ProductCardFragment> generator = new FragmentGenerator<>(ProductCardFragment.class);
        return generator.getFragments(cardTypeList);
    }

    public List<AddToCartFragment> addToCart() {
        FragmentGenerator<AddToCartFragment> generator = new FragmentGenerator<>(AddToCartFragment.class);
        return generator.getFragments(addToCartList);
    }

    public boolean isRedirectedToProductPage(String product) {
        String productURL = product.replaceAll("\\s", "-");
        return getDriver().getCurrentUrl().contains(productURL);
    }

    public boolean isCartPagePresent(WebElement cartTypeList){
        return Waits.waitUntilIsPresent(cartTypeList);
    }

    public ProductCardFragment getCardType(String cardType) {
        return getCardList().stream()
                .filter(element -> element.getText().contains(cardType))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unable to find card"));
    }

    public ProductFragment getProductByISBN(String isbn) {
        return getProducts().stream()
              //  .filter(product -> product.getProductNumber().equals(isbn))
                .filter(product -> product.getProductNumberText().equals(isbn))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Unable to find product with ISBN "+isbn));
    }

    public AddToCartFragment getCartType() {
        return addToCart().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unable to find cart "));
    }


    public void clickOnCardType(String cardType){
       getCardType(cardType).clickOnCard();
    }

    public void clickOnproduct(String isbn){
        getProductByISBN(isbn).clickOnAddToCartButton();
    }

    public void waitUntilSmallCartPageIsOpened(){
        Waits.waitUntilIsVisible(getCartType());
    }

    public void clickOnViewCart(){
  //      Waits.waitUntilIsVisible(smallCartListPage);
        getCartType().clickOnViewCart();
    }
//    public ProductFragment getProductByISBN(String isbn) {
//        return getProducts().stream()
//                //  .filter(product -> product.getProductNumber().equals(isbn))
//                .filter(product -> product.findElement(product.xpathProductNumber).getText().equals(isbn))
//                .findFirst()
//                .orElseThrow(()->new IllegalArgumentException("Unable to find product with ISBN "+isbn));
//    }

}
