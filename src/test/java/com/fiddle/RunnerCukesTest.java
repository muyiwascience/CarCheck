package com.fiddle;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = ("src/test/resources"),
        plugin = {
                "pretty",
                "html:target/cucumber/cucmberTestReport-html",
                "json:target/cucumber/cucmberTestReportJson.json",
                "junit:target/cucumber/cucmberTestReportJunit-xml.xml"},
        strict = false,
        snippets = SnippetType.CAMELCASE,
        tags = {"@working"}
)
public class RunnerCukesTest {
}
