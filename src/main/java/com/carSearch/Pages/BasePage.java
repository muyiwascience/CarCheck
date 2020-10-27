package com.carSearch.Pages;

import com.carSearch.DataReaderEngine.ConfigTestPropertiesReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


import java.util.concurrent.TimeUnit;


public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    final String website = ConfigTestPropertiesReader.getValue("website.url");



    @FindBy(css = "#head > header > a > img")
    WebElement icon;



    public void clickIconButton() {
        icon.click();
    }



    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void searchPlateNumber(String plateNumber) {
        driver.findElement(By.id("vrm-input")).sendKeys(plateNumber);
        driver.findElement(By.tagName("button")).click();
    }

    public boolean searchResultIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            if (driver.findElement(By.cssSelector("div.jsx-1606339439 div.jsx-79705764:nth-child(3) div.jsx-2427602283.modal-bg.visible:nth-child(14) div.jsx-2427602283.modal > div.jsx-1434943695")).isDisplayed()) {
//                System.out.println("REG NUMBER NOT FOUND AND POP UP DISPLAYED");
                return false;

            }
        } catch (NoSuchElementException e) {
            System.out.println("REG NUMBER FOUND");
        }
        return true;
    }
    public String getRegistrationNumber(){
        return driver.findElement(By.cssSelector("div.jsx-4182171069:nth-child(4) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(2) > dl:nth-child(1) > dd:nth-child(2)")).getText();
    }

    public String getMake(){
        return driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[4]/div[1]/div/span/div[2]/dl[2]/dd")).getText();
    }

    public String getModel(){
        return driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[4]/div[1]/div/span/div[2]/dl[3]/dd")).getText();
    }

    public String getColor(){
        return driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[4]/div[1]/div/span/div[2]/dl[4]/dd")).getText();
    }

    public String getYear(){
        return driver.findElement(By.xpath("//*[@id=\"m\"]/div/div[4]/div[1]/div/span/div[2]/dl[5]/dd")).getText();
    }

}

