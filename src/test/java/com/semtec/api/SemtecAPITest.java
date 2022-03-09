package com.semtec.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@Suite
@IncludeEngines("cucumber")
@RunWith(Cucumber.class)
@SelectClasspathResource("Feature")
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, features = "classpath:Feature")
public class SemtecAPITest {
}
