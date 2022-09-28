package com.pearson.automation.components.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.pearson.automation.testBase.AbstractPage;
import com.pearson.automation.testBase.Page;
import com.pearson.automation.utils.CommonMethods;
@Lazy
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Page.URL(URL = "https://www.pearsonassessments.com/store/usassessments/en/login")

public class SignInPage extends AbstractPage {

    //private Select dropdown;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='loginRegistration__card']//button[@type='submit']")
    private WebElement signInButton;



    public void insertUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void insertPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void pressOnSignInButton() {
        signInButton.click();

    }

    public boolean isSignInButtonPresent() {
        return CommonMethods.isPresent(signInButton);
    }

}

//      Select drop = new Select(dropdown);
//       getDriver()
//        signInButton.sendKeys(keys.chord(key.CONTROL,Keys.));
//          signInButton.sendKeys(Keys.chord(Keys.CONTROL+"a"));
//         dropdown.getWrapper