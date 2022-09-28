package com.pearson.automation;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumbers")
@SelectClasspathResource("features")
public class BaseCucumberTests {
}
