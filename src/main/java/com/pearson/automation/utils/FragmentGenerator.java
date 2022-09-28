package com.pearson.automation.utils;

import com.pearson.automation.components.fragments.AbstractFragment;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FragmentGenerator<T extends AbstractFragment> {

    private final Class<T> t;

    public FragmentGenerator(Class<T> t) {
        this.t = t;
    }

    private Class<T> getType() {
        return t;
    }

    private T generateFragment(WebElement webElement) {
        try {
            return getType().getDeclaredConstructor(WebElement.class).newInstance(webElement);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("There is an issue with converting the Web elements into Fragments");
    }

    public List<T> getFragments(List<WebElement> webElementList) {
        List<T> fragmentList = new ArrayList<>();
        webElementList.forEach(webElement -> {
            fragmentList.add(generateFragment(webElement));
        });
        return fragmentList;
    }
}
