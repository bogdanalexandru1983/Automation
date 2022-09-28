package com.pearson.automation.components.pages;

import com.pearson.automation.components.fragments.StoreModalFragment;
import com.pearson.automation.utils.FragmentGenerator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.pearson.automation.testBase.AbstractPage;
import com.pearson.automation.testBase.Page;

import java.util.ArrayList;
import java.util.List;

import static com.pearson.automation.testBase.Waits.getWaitObject;

@Lazy
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Page.URL(URL = "https://www.pearsonassessments.com")
public class HomePage<list> extends AbstractPage {
    @FindBy(xpath = "//a[@class='userNav__button jsUserNotSignedInIdentifier']")
    private WebElement signInButton;

    @FindBy(xpath = "//button[@class='pop-up__button pop-up-button-close']")
    private WebElement stayOnTheUsSite;

    @FindBy(xpath = "//button[@class='pop-up-close']")
    private WebElement closeStoreslink;

    @FindBy(xpath = "//a[@id='cookie-notification-policy-accept-continue']")
    private WebElement closeCookies;

 //   @FindBy(xpath = "//input[@class='ais-SearchBox-input search-box-input']")
    @FindBy(xpath="//input[contains(@class,'ais-SearchBox-input search-box-input')]")
    private WebElement searchBar;

    @FindBy(xpath = "//a[contains(@class, 'choose-location-link')]/ancestor::div[@class='pop-up'] | //div[@class='pop-up']")
    private List<WebElement> webElementlist;

    public List<StoreModalFragment> getStoreModals(){
        FragmentGenerator<StoreModalFragment> generator = new FragmentGenerator<>(StoreModalFragment.class);
        return generator.getFragments(webElementlist);
    }

    public StoreModalFragment getFirstStoreModal(){
        return getStoreModals().stream().findFirst().orElseThrow(()->new IllegalStateException("Unable to find any store Nodal"));

    }

//    public List<StoreModalFragment> getFragmentList(){
//        List<StoreModalFragment> modals=new ArrayList<>();
//        webElementlist.forEach(webElement->{
//            modals.add(new StoreModalFragment(webElement));
//        });
//        return modals;
//    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickStayOnTheUsSite() {
        stayOnTheUsSite.click();
    }

    public void clickCloseStoreslink() {
        closeStoreslink.click();
    }

    public boolean isStayOnTheUsSiteDisplayed() {
        try {
            stayOnTheUsSite.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void closeCookiesBanner() {
        closeCookies.click();
    }

    public void insertTextOnSearchBar(String text) {
        searchBar.sendKeys(text);
        searchBar.sendKeys(Keys.ENTER);
//        searchBar.sendKeys("text"+Keys.ENTER);

    }

   public void clickOnSearchBar() {
        searchBar.sendKeys(Keys.ENTER);
    }

}
