package com.pearson.automation.components.pages;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.pearson.automation.testBase.AbstractPage;
import com.pearson.automation.testBase.Page;
@Lazy
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Page.URL(URL="https://www.pearsonassessments.com/search.html",format="https://www.pearsonassessments.com/search.html(.+)?")
public class SearchPage extends AbstractPage {

}
