package ui.pageobjects.sbb;


import org.junit.rules.Timeout;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public static final By inputFrom = byId("fromField");
    public static final By inputTo = byId("toField");
    public static final By btnVerbindungSuchen = byXpath("//div[@data-timetableinputform='button_wrapper']");
    public static final By btnTouchFahrplan = byXpath("//button[@data-sit-component='timetable switch']//span");
    public static final By inputDate = byId("datepicker1");
    public static final By inputTime = byId("timepicker");
    public static final By btnToggleAnAb = byId("toggleButtonId_second_option");
    public static final By btnSwitchLocations = byXpath("//button[@data-timetableinputform='swap_button']");
    public static final By btnPreviousDay = byXpath("//button[@data-datepicker='button_previous_day']");
    public static final By btnNextDay = byXpath("//button[@data-datepicker='button_next_day']");
    public static final By inputVia = byId("viaField1");
    public static final By btnAddVia = byCssSelector(".mod_timetable_input_form_viawrapper > button");
    public static final By btnAcceptCookies = byId("onetrust-accept-btn-handler");


    public void setFrom(String from) {
        $(inputFrom).should(appear).sendKeys(from);
    }

    public void setTo(String to) {
        $(inputTo).should(appear).sendKeys(to);
    }

    public String getTextFrom() {
        return $(inputFrom).should(appear).getText();
    }

    public void setDate(String date) {
        $(inputDate).should(appear).clear();
        $(inputDate).should(appear).sendKeys(date);
    }
    public void setTime(String time) {
        $(inputTime).should(appear).clear();
        $(inputTime).should(appear).sendKeys(time);
    }
    public void changeAnAb(String option) {

        if(option.contains("Ankunft")) {
            $(btnToggleAnAb).should(appear).click();
        }
    }
    public void switchLocations() {
        $(btnSwitchLocations).should(appear).click();
    }
    public void clickPreviousDay(int days) {
        for (int i=1; i<=days; i++){
            $(btnPreviousDay).should(appear).click();
        }
    }

    public void clickNextDay(int days) {
        for (int i=1; i<=days; i++){
            $(btnNextDay).should(appear).click();
        }
    }
    public void clickAddVia() {
        $(btnAddVia).should(appear).click();
    }
    public void setVia(String via) {
        clickAddVia();
        $(inputVia).should(appear).sendKeys(via);
    }
    public void searchConnection() {
        $(btnVerbindungSuchen).should(appear).click();
    }
    public void clickAcceptCookies() {
        $(btnAcceptCookies).should(appear, Duration.ofSeconds(30)).click();
    }

}
