package com.carSearch.Infrastructure;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LocalCustomCapabilities {
    String systemPath;
    ChromeOptions chromeOptions = new ChromeOptions();
    String chromePath;
    String firefoxPath;

    public LocalCustomCapabilities() {
        systemPath = System.getProperty("user.dir");
    }

    public WebDriver getFirefoxDriver(String operatingSystem) throws Exception {
        if(operatingSystem.equalsIgnoreCase("mac")) {
            this.firefoxPath = systemPath + "/Drivers/Mac/Firefox/geckodriver";
        }else if (operatingSystem.equalsIgnoreCase("linux")) {
            this.firefoxPath = systemPath + "/Drivers/Linux/Firefox/firefoxdriver.exe";
        }else if(operatingSystem.equalsIgnoreCase("windows")){
            this.firefoxPath = systemPath + "\\Drivers\\Windows\\Firefox\\geckodriver.exe";
        }
        else {
            throw new Exception("check chosen operating system");
        }
        System.setProperty("webdriver.gecko.driver", firefoxPath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setJavascriptEnabled(true);
        return new FirefoxDriver(capabilities);
    }

    public WebDriver getChromeDriver(String operatingSystem) throws Exception {
        if(operatingSystem.equalsIgnoreCase("mac")) {
            this.chromePath = systemPath + "/Drivers/Mac/Chrome/chromedriver";
        }else if (operatingSystem.equalsIgnoreCase("linux")) {
            this.chromePath = systemPath + "/Drivers/Linux/Firefox/firefoxdriver.exe";
        }else if(operatingSystem.equalsIgnoreCase("windows")){
            this.chromePath = systemPath + "\\Drivers\\Windows\\Firefox\\geckodriver.exe";
        }
        else {
            throw new Exception("check chosen operating system");
        }
        System.setProperty("webdriver.chrome.driver", chromePath);
        chromeOptions.addArguments("--start-maximise");
        chromeOptions.addArguments("--enable-javascript");
        return new ChromeDriver(chromeOptions);
    }
}
