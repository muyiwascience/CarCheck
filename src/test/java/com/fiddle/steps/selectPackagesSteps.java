package com.fiddle.steps;

import com.carSearch.DataReaderEngine.CarInputOutputData;
import com.carSearch.Support.WorldHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class selectPackagesSteps {
    WorldHelper worldHelper = new WorldHelper();

    CarInputOutputData getData = new CarInputOutputData();


    @Given("^I verify current url$")
    public void iVerifyCurrentUrl() {
        String urlCartaxcheck = worldHelper.getBasePage().getCurrentUrl();
        System.out.println("The website under test: "+urlCartaxcheck);
        Assert.assertEquals("https://cartaxcheck.co.uk/",worldHelper.getBasePage().getCurrentUrl(), "VWebsite URL not correct");
    }


    @When("^I perform search on the first registration number DN09HRM$")
    public void iPerformSearchOnTheFirstRegistrationNumber() throws IOException {
        worldHelper.getBasePage().searchPlateNumber(getData.getPlateNumber().get(0));

    }

    @When("^I perform search on the second registration number BW57BOW$")
    public void iPerformSearchOnTheSeondRegistrationNumber() throws IOException {
        worldHelper.getBasePage().searchPlateNumber(getData.getPlateNumber().get(1));

    }

    @And("^i verify that i am on the search result page$")
    public void iVerifyThatIAmOnTheSearchResultPage() {
        Assert.assertTrue(worldHelper.getBasePage().searchResultIsDisplayed(), "ERROR: CHECK REGISTRATION NUMBER");
    }

    @Then("^I verify car details match with output text data for DN09HRM$")
    public void iVerifyCarDetailsMatchWithOutputTextData() throws IOException {
        String reg = worldHelper.getBasePage().getRegistrationNumber();
        String make = worldHelper.getBasePage().getMake();
        String model = worldHelper.getBasePage().getModel();
        String color = worldHelper.getBasePage().getColor();
        String year = worldHelper.getBasePage().getYear();
        System.out.println("Registation number from website: "+reg);
        System.out.println("Make number from website: "+make);
        System.out.println("Model number from website: "+model);
        System.out.println("Color number from website: "+color);
        System.out.println("Year number from website: "+year);
        List<String>carDets = Arrays.asList((getData.getCarDetails(getData.getPlateNumber().get(0))));
        System.out.println("Details from output file");
        System.out.println(carDets);
        Assert.assertTrue(carDets.contains(reg));
        Assert.assertTrue(carDets.contains(make));
        Assert.assertTrue(carDets.contains(model));
        Assert.assertTrue(carDets.contains(color));
        Assert.assertTrue(carDets.contains(year));

    }

    @Then("^I verify car details match with output text data for BW(\\d+)BOW$")
    public void iVerifyCarDetailsMatchWithOutputTextDataForBWBOW(int arg0) throws IOException {
        String reg = worldHelper.getBasePage().getRegistrationNumber();
        String make = worldHelper.getBasePage().getMake();
        String model = worldHelper.getBasePage().getModel();
        String color = worldHelper.getBasePage().getColor();
        String year = worldHelper.getBasePage().getYear();
        System.out.println("Registation number from website: "+reg);
        System.out.println("Make number from website: "+make);
        System.out.println("Model number from website: "+model);
        System.out.println("Color number from website: "+color);
        System.out.println("Year number from website: "+year);
        List<String>carDets = Arrays.asList((getData.getCarDetails(getData.getPlateNumber().get(1))));
        System.out.println("Details from output file");
        System.out.println(carDets);
        Assert.assertTrue(carDets.contains(reg));
        Assert.assertTrue(carDets.contains(make));
        Assert.assertTrue(carDets.contains(model));
        Assert.assertTrue(carDets.contains(color));
        Assert.assertTrue(carDets.contains(year));

    }

    @When("^I perform search on the third registration number KT(\\d+)DLX$")
    public void iPerformSearchOnTheThirdRegistrationNumberKTDLX(int arg0) throws IOException {
        worldHelper.getBasePage().searchPlateNumber(getData.getPlateNumber().get(2));
    }

    @Then("^I verify car details match with output text data for KT(\\d+)DLX$")
    public void iVerifyCarDetailsMatchWithOutputTextDataForKTDLX(int arg0) throws IOException {
        String reg = worldHelper.getBasePage().getRegistrationNumber();
        String make = worldHelper.getBasePage().getMake();
        String model = worldHelper.getBasePage().getModel();
        String color = worldHelper.getBasePage().getColor();
        String year = worldHelper.getBasePage().getYear();
        System.out.println("Registation number from website: "+reg);
        System.out.println("Make number from website: "+make);
        System.out.println("Model number from website: "+model);
        System.out.println("Color number from website: "+color);
        System.out.println("Year number from website: "+year);
        List<String>carDets = Arrays.asList((getData.getCarDetails(getData.getPlateNumber().get(2))));
        System.out.println("Details from output file");
        System.out.println(carDets);
        Assert.assertTrue(carDets.contains(reg));
        Assert.assertTrue(carDets.contains(make));
        Assert.assertTrue(carDets.contains(model));
        Assert.assertTrue(carDets.contains(color));
        Assert.assertTrue(carDets.contains(year));

    }

    @When("^I perform search on the fourth registration number SG(\\d+)HTN$")
    public void iPerformSearchOnTheFourthRegistrationNumberSGHTN(int arg0) throws IOException {
        worldHelper.getBasePage().searchPlateNumber(getData.getPlateNumber().get(3));
    }

    @Then("^I verify car details match with output text data for SG(\\d+)HTN$")
    public void iVerifyCarDetailsMatchWithOutputTextDataForSGHTN(int arg0) throws IOException {
        String reg = worldHelper.getBasePage().getRegistrationNumber();
        String make = worldHelper.getBasePage().getMake();
        String model = worldHelper.getBasePage().getModel();
        String color = worldHelper.getBasePage().getColor();
        String year = worldHelper.getBasePage().getYear();
        System.out.println("Registation number from website: "+reg);
        System.out.println("Make number from website: "+make);
        System.out.println("Model number from website: "+model);
        System.out.println("Color number from website: "+color);
        System.out.println("Year number from website: "+year);
        List<String>carDets = Arrays.asList((getData.getCarDetails(getData.getPlateNumber().get(3))));
        System.out.println("Details from output file");
        System.out.println(carDets);
        Assert.assertTrue(carDets.contains(reg));
        Assert.assertTrue(carDets.contains(make));
        Assert.assertTrue(carDets.contains(model));
        Assert.assertTrue(carDets.contains(color));
        Assert.assertTrue(carDets.contains(year));
    }
}
