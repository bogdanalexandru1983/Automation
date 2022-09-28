package com.pearson.automation.stepDefinitions.pages;

import com.pearson.automation.components.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.pearson.automation.testBase.WebDriverContainer.getDriver;

public class SignInPageStepDefs {

    SignInPage signInPage = new SignInPage();

    @Then("^Sign in Page: Customer is redirected to sign in page$")
    public void customer_is_redirected_to_sign_in_page() {
        String url = signInPage.getURL();
        // assertTrue(url.contains("login"), String.format("URL: %s does not contain 'login'' word",url));
  //      assertEquals("https://www.pearsonassessments.com/store/usassessments/en/login", url, "URL is different than expected one!");
        assertEquals(url, getDriver().getCurrentUrl(), "URL is different than expected one!");
    }
    @And("Sign in Page: Customer fill in the username: {string}")
    public void insert_username(String username){
        signInPage.insertUsername(username);
    }

    @And("^Sign in Page: Customer fill in the password: (.*)$")
    public void insert_password(String password){
        signInPage.insertPassword(password);
    }
    @And("^Sign in Page: Customer clicks sign in button from sign in page$")
    public void press_On_Sign_In_Button(){
        signInPage.pressOnSignInButton();
    }


}
