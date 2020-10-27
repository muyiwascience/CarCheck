package com.fiddle.Hooks;

import com.carSearch.DataReaderEngine.ConfigTestPropertiesReader;
import com.carSearch.Infrastructure.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberScenerioHooks {

    private BrowserFactory browserFactory;


    @Before
    public void startTest() throws Exception {
        String browserName = ConfigTestPropertiesReader.getValue("Browser.Type");
        String executionEnvironment = ConfigTestPropertiesReader.getValue("execution.environment");
        this.browserFactory = new BrowserFactory();
        browserFactory.initialiseAndOpenBrowser(executionEnvironment, browserName);
        }


   @After
    public void endTest() {
        browserFactory.tearDownDriver();
    }
}
