package com.fiddle.Hooks;

import com.carSearch.DataReaderEngine.ConfigTestPropertiesReader;
import com.carSearch.Infrastructure.BrowserFactory;

import com.carSearch.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class Hooks {

    protected WebDriver driver;
    protected BrowserFactory browserFactory;
    protected BasePage basePage;


   @BeforeClass
    public void beforeAllTest() {
        System.out.println("This will run once before tests");
    }

   @BeforeMethod
    public WebDriver startTest() throws Exception {
        String browserName = ConfigTestPropertiesReader.getValue("Browser.Type");
        String executionEnviroment = ConfigTestPropertiesReader.getValue("execution.environment");
        browserFactory = new BrowserFactory();
        this.driver = browserFactory.initialiseAndOpenBrowser(executionEnviroment, browserName);
        basePage = PageFactory.initElements(driver, BasePage.class);
        return driver;

    }


    @AfterMethod
    public void stopTest(ITestResult testResult){
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("test was unsuccessful");
        }
        else if(testResult.getStatus() == ITestResult.SUCCESS){
            System.out.println("test was successful");
        }
        browserFactory.tearDownDriver();
    }
        @AfterClass
        public void afterAllTest() {
            System.out.println("this will run once after all tests have completed running");
        }

}