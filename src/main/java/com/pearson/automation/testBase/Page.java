package com.pearson.automation.testBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import static org.apache.logging.log4j.util.Strings.EMPTY;

import static org.apache.commons.lang.StringUtils.EMPTY;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Page {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface URL{
        String URL() default EMPTY;
        String format() default EMPTY;
    }
}
