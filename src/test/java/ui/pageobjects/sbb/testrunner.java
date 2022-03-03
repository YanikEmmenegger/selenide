package ui.pageobjects.sbb;


import ui.pageobjects.constants;

import static ui.pageobjects.constants.*;


public class testrunner {
    public static void main(String[] args) {
        new constants().setUp(URL_SBB, "edge");

        HomePage homePage = new HomePage();
        String From = "Ittigen";
        String To = "Bern";
        String Time = "15:00";
        String Date = "29.02.2022";
        String Via = "Bolligen";
        String AnAb = "Abfahrt";


        homePage.clickAcceptCookies();
        homePage.setFrom(From);
        homePage.setTo(To);
        //HomePage.clickAddVia();
        if(Via != "") {
            homePage.setVia(Via);
        }
        homePage.setTime(Time);
        homePage.setDate(Date);
        homePage.clickNextDay(2);
        homePage.clickPreviousDay(2);
        homePage.switchLocations();
        homePage.changeAnAb(AnAb);

        homePage.searchConnection();

    }
}
