package com.pearson.automation.stepDefinitions.fragments;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import com.pearson.automation.components.fragments.StoreModalFragment;

import static com.pearson.automation.utils.ElementUtils.waitUntilIsVisible;

public class StoremodalStepDefs {
    @Autowired
    private StoreModalFragment storeModal;

    @Given("Store modal is displayed")

    public void store_modal_is_displayed(){
        waitUntilIsVisible(storeModal);
    }
    @Given("Customer clicks on close button from store modal")
    public void customer_clicks_on_close_button_from_store_modal(){
        storeModal.clickOnCloseButton();
    }

}
