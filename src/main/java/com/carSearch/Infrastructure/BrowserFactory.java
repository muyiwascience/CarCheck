package com.carSearch.Infrastructure;
import com.carSearch.DataReaderEngine.ConfigTestPropertiesReader;
import org.openqa.selenium.WebDriver;

public class BrowserFactory{

    protected static WebDriver driver;
    final String website = ConfigTestPropertiesReader.getValue("website.url");


    public WebDriver initialiseAndOpenBrowser(String executionEnvironment, String browser) throws Exception {
        if (executionEnvironment.equalsIgnoreCase("local")) {
            setUpBrowserOnLocalMachine(browser);
        } else if (executionEnvironment.equalsIgnoreCase("remote")) {
            System.out.println("No remote available");
        } else {
            throw new IllegalStateException("there is no such environment");
        }
        this.prepareBrowser();
        driver.navigate().to(website);
        return driver;
    }

    public void prepareBrowser() {
       driver.manage().window().maximize();
    }

    private void setUpBrowserOnLocalMachine(String browser) throws Exception {
        LocalCustomCapabilities localCustomCapabilities = new LocalCustomCapabilities();
                String operatingSystem = ConfigTestPropertiesReader.getValue("os");
                    if (browser.equalsIgnoreCase("firefox")) {
                        driver = localCustomCapabilities.getFirefoxDriver(operatingSystem);
                    } else if (browser.equalsIgnoreCase("chrome")) {
                        driver = localCustomCapabilities.getChromeDriver(operatingSystem);
                    } else{
                        System.out.println("no such browser");
                    }
                }

        public void tearDownDriver() {
            if (driver != null)
                driver.quit();
        }
    }

