package com.pearson.automation.stepDefinitions.pages;

import com.pearson.automation.components.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageStepDefs {
    HomePage homePage = new HomePage();

    @Given("^Home Page: Customer opens home page$")
    public void customer_opens_home_page() {
        homePage.navigate();
    }

    @And("Home Page: Customer clicks on StayOnTheUsSite")
    public void customer_clicks_on_clickStayOnTheUsSite() {
      if(homePage.isStayOnTheUsSiteDisplayed()){
          homePage.clickStayOnTheUsSite();
    }
      else homePage.clickCloseStoreslink();
    }


    @And("Home Page: Customer clicks on Cookies Banner")
    public void customer_clicks_on_cookies_banner() {
        homePage.closeCookiesBanner();
    }

    @Then("Home Page: Customer clicks sign in button")
    public void customer_clicks_sign_in_button() {
        homePage.clickSignInButton();
    }

    @Then("^Customer is redirected to home page$")
    public void customer_is_redirected_to_home_page() {
        String url = homePage.getURL();
        // assertTrue(url.contains("login"), String.format("URL: %s does not contain 'login'' word",url));
        assertEquals("https://www.pearsonassessments.com", url, "URL is different than expected one!");
    }

    @Given("^Home Page: Customer insert on search bar: (.*)$")
    public void insert_text_on_search_bar(String text) {
        homePage.insertTextOnSearchBar(text);
    }

    @And("^Home Page: Customer clicks on enter$")
    public void click_on_search_bar(){
        homePage.clickOnSearchBar();
    }

    @And ("close modal")
    public void customer_clicks_on_close_button_from_modal() {
        homePage.getFirstStoreModal().clickOnCloseButton();
    }



}
