package com.pearson.automation.stepDefinitions.core;


import com.pearson.automation.testBase.WebDriverContainer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static com.pearson.automation.testBase.WebDriverContainer.getDriver;

public class ScenarioHooks {
    @Before
    public void beforeEach(){
        getDriver();

    }

    @After
    public void afterEach(){
  //     getDriver().manage().deleteAllCookies();
    //    WebDriverContainer.quit();
    }
}
