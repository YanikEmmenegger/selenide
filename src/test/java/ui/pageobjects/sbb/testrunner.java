package ui.pageobjects.sbb;


import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.tinylog.Logger;
import ui.pageobjects.constants;

import static ui.pageobjects.constants.*;


public class testrunner {
    public static void main(String[] args) throws InterruptedException {
        new constants().setUp(URL_SBB);//Without Browser = Chrome

        HomePage homePage = new HomePage();
        String From = "Ittigen";
        String To = "Bern";
        String Time = "15:00";
        String Date = "29.03.2022";
        String Via = "Bolligen";
        String AnAb = "Abfahrt";

        homePage.clickAcceptCookies();
        homePage.setFrom(From);
        homePage.setTo(To);
        //HomePage.clickAddVia();
        if(Via != "") {homePage.setVia(Via);}
        homePage.setTime(Time);
        homePage.setDate(Date);
        homePage.clickNextDay(2);
        homePage.clickPreviousDay(2);
        homePage.switchLocations();
        homePage.changeAnAb(AnAb);
        homePage.searchConnection();

        ConnectionPage ConnPage = new ConnectionPage();
        Logger.info(ConnPage.getTextTitleDateTime());
        Logger.info(ConnPage.getTextTitleFrom());
        Logger.info(ConnPage.getTextTitleTo());

        Logger.info(ConnPage.getAllConnections());
        ConnPage.addTicketToCart();

        OnboardingPage onboardingPage = new OnboardingPage();
        onboardingPage.loginAsGuest();

        OfferPage OfferPage = new OfferPage();
        OfferPage.setPassengerInfos("Yanik", "Emmenegger", "26.08.1999", false, false, false, false);
        OfferPage.setPassengerInfos("Yanik", "Emmenegger", "26.08.1999", false, false, false, false);

        Thread.sleep(10000);

    }
}
