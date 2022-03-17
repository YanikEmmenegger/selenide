package ui.tests.stepdefinitions.sbb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tinylog.Logger;
import ui.pageobjects.constants;
import ui.pageobjects.sbb.ConnectionPage;
import ui.pageobjects.sbb.HomePage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.pageobjects.constants.URL_SBB;

public class StepDefsSbb {

    HomePage homePage = new HomePage();
    ConnectionPage connPage = new ConnectionPage();

    @Given("User opens SBB Homepage")
    public void user_opens_sbb_homepage(){
        new constants().setUp(URL_SBB);
        homePage.clickAcceptCookies();
    }
    @When("user sets from {string}")
    public void user_sets_from_something(String from){
        homePage.setFrom(from);
    }
    @Then("user gets connections")
    public void user_gets_connections(){
        ArrayList<ConnectionPage.SBBConnection> Collection = connPage.getAllConnections();
        Logger.info("There were found {} Connections ", Collection.size());
        assertTrue(Collection.size() > 0);
    }
    @And("user sets to {string}")
    public void user_sets_to_something(String to){
        homePage.setTo(to);
    }
    @And("User sets via {string}")
    public void user_sets_via_something(String via){
        homePage.setVia(via);
    }
    @And("User sets date {string}")
    public void user_sets_date_something(String date){
        homePage.setDate(date);
    }
    @And("user sets time {string}")
    public void user_sets_time_something(String time){
        homePage.setTime(time);
    }
    @And("user sets dep_arr {string}")
    public void user_sets_deparr_something(String deparr){
        homePage.changeAnAb(deparr);
    }
    @And("user starts search")
    public void user_starts_search(){
        homePage.searchConnection();
    }
    @And("connection date is {string}")
    public void connection_date_is_something(String date){
        assertTrue(connPage.getTextTitleDateTime().contains(date));
    }
    @And("connection time is {string}")
    public void connection_time_is_something(String time){
        assertTrue(connPage.getTextTitleDateTime().contains(time));
    }
    @And("connection from is {string}")
    public void connection_from_is_something(String from){
        assertTrue(connPage.getTextTitleFrom().contains(from));
    }
    @And("connection to is {string}")
    public void connection_to_is_something(String to){
        assertTrue(connPage.getTextTitleTo().contains(to));
    }
    @And("connection via is {string}")
    public void connection_via_is_something(String via){
        assertTrue(connPage.getTextTitleDateTime().contains(via));
    }
}
