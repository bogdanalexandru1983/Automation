package com.pearson.automation.stepDefinitions.pages;

import com.pearson.automation.components.pages.SearchPage;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.pearson.automation.testBase.WebDriverContainer.getDriver;

public class SearchPageStepDef {
    SearchPage searchPage = new SearchPage();

    @Then("^Search Page: Customer is redirected to Search page$")
    public void customer_is_redirected_to_sign_in_page() {
        String url = searchPage.getURL();
     //   assertEquals(url, getDriver().getCurrentUrl(), "URL is different than expected one!");
        searchPage.waitUntilLoaded();
    }

}
