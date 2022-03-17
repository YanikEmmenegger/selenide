package ui.pageobjects.sbb;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.tinylog.Logger;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConnectionPage {

    public static final By textDateTime = byXpath("//h2[@class='mod_pagesubtitle']//span[2]");
    public static final By textTitleTo = byXpath("(//h1[@data-init='pagetitle'])[1]//span[3]");
    public static final By textTitleFrom = byXpath("(//h1[@data-init='pagetitle'])[1]//span[2]");
    public static final By btnChangeConnection = byCssSelector(".mod_pagesubtitle_button_change");
    public static final By selectAnsicht = byId("shopForm_j_idt932_valueComp");
    public static final By btnEarlyConnections = byId("previous-connections-id");
    public static final By btnLaterConnections = byId("verbindungsUebersicht_spaetereVerbindungenSuchen");
    public static final By allconnections = byXpath("//div[@data-timetablenbc='item']");


    public String getTextTitleFrom() {
        return $(textTitleFrom).should(appear).getText();
    }
    public String getTextTitleTo() {
        return $(textTitleTo).should(appear).getText();
    }
    public String getTextTitleDateTime() {
        return $(textDateTime).should(appear).getText();
    }
    public void clickEarlyConnections() {
        $(btnEarlyConnections).should(appear).click();
    }
    public void clickLaterConnection() {
        $(btnLaterConnections).should(appear).click();
    }


    public void clickChangeConnection(){
        $(btnChangeConnection).should(appear).click();
    }

    public void changeTravelType(String selectValue){
        Select select = new Select($(selectAnsicht));
        select.deselectByValue(selectValue); //Standard-Ansicht oder Barrierefreies Reisen
    }

    public ArrayList<SBBConnection> getAllConnections(){
        ArrayList<SBBConnection> connections = new ArrayList<SBBConnection>();
        for (SelenideElement connection : $$(allconnections)) {
            String richtung = connection.findElement(By.className("mod_timetable_direction_text")).getText();
            String start = connection.findElement(By.cssSelector(".mod_timetable_starttime > span")).getText();
            String end = connection.findElement(By.cssSelector(".mod_timetable_endtime > span")).getText();
            String dauer = connection.findElement(By.cssSelector(".mod_timetable_duration > span")).getText();
            String umsteigen = connection.findElement(By.className("mod_timetable_change_label")).getText();
            SelenideElement btnBuyTicket = connection.find(By.className("mod_timetable_buy_button_label"));
            SelenideElement btnSeeMore = connection.find(By.className("mod_accordion_item_link_open"));
            String preisWithoutChar = btnBuyTicket.getText().replaceAll("[^\\d.]", "");
            double preis = Double.parseDouble(preisWithoutChar.substring(0, preisWithoutChar.length() - 2));
            SBBConnection ConnObj = new SBBConnection(richtung, start, end, dauer, umsteigen, preis, btnBuyTicket, btnSeeMore);
            connections.add(ConnObj);
        }
        return connections;
    }
    public boolean addTicketToCart(String richtung, String start, String end, String dauer) {

        for (SBBConnection connection : getAllConnections()) {
            Logger.info("\nAbfahrt: "+connection.getStart()+"\nAnkunft:"+
                    connection.getEnd()+"\nDauer: "+
                    connection.getDauer()+"\nPreis: "+
                    connection.getTicketPreis()+"\nRichtung: "+
                    connection.getRichtung());

            if (connection.getRichtung().contains(richtung)
                    &&connection.getStart().contains(start)
                    &&connection.getEnd().contains(end)
                    &&connection.getDauer().contains(dauer)) {
                Logger.info("Connection Found");

                connection.getBtnBuyTicket().click();
                return true;
            }
        }
        return false;
    }
    public boolean addTicketToCart(){
        SBBConnection connection = getAllConnections().get(0);
        Logger.info("\nAbfahrt: "+connection.getStart()+"\nAnkunft:"+
                connection.getEnd()+"\nDauer: "+
                connection.getDauer()+"\nPreis: "+
                connection.getTicketPreis()+"\nRichtung: "+
                connection.getRichtung());
        connection.btnBuyTicket.click();
        return true;
    }

    public class SBBConnection {

        private final String richtung;
        private final String start;
        private final String end;
        private final String dauer;
        private final String umsteigen;
        private final double ticketPreis;
        private final SelenideElement btnBuyTicket;
        private final SelenideElement btnSeeMore;

        public String getRichtung() {
            return richtung;
        }

        public double getTicketPreis() {
            return ticketPreis;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public String getDauer() {
            return dauer;
        }

        public String getUmsteigen() {
            return umsteigen;
        }

        public SelenideElement getBtnBuyTicket() {
            return btnBuyTicket;
        }

        public SBBConnection(String richtung, String start, String end, String dauer, String umsteigen, double ticketPreis,
                             SelenideElement btnBuyTicket, SelenideElement btnSeeMore) {
            super();
            this.richtung = richtung;
            this.start = start;
            this.end = end;
            this.dauer = dauer;
            this.umsteigen = umsteigen;
            this.ticketPreis = ticketPreis;
            this.btnBuyTicket = btnBuyTicket;
            this.btnSeeMore = btnSeeMore;
        }
    }
}
