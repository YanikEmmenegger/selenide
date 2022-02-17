package ui.pageobjects.sbb;

import com.codeborne.selenide.Configuration;

import java.awt.*;

import static com.codeborne.selenide.Selenide.open;
import static ui.pageobjects.constants.*;

public class testrunner {
    public static void main(String[] args) {
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.timeout = IMPLICIT_WAIT_TIMEOUT;
        Configuration.browser = "chrome";

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        Configuration.browserSize = width+"x"+height;
        Configuration.browserPosition = "0x0";
        open(SbbUrl);

        HomePage homePage = new HomePage();
        String From = "Ittigen";
        String To = "Bern";
        String Time = "15:00";
        String Date = "20.02.2022";
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
