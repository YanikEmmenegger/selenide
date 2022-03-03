package ui.pageobjects.sbb;

import org.openqa.selenium.By;
import org.tinylog.Logger;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

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
    /*
    public ArrayList<SBBConnection> getAllConnections(){
        ArrayList<SBBConnection> connections = new ArrayList<SBBConnection>();
        for (WebElement connection : allconnections) {
            String richtung = connection.findElement(By.className("mod_timetable_direction_text")).getText();
            String start = connection.findElement(By.cssSelector(".mod_timetable_starttime > span")).getText();
            String end = connection.findElement(By.cssSelector(".mod_timetable_endtime > span")).getText();
            String dauer = connection.findElement(By.cssSelector(".mod_timetable_duration > span")).getText();
            String umsteigen = connection.findElement(By.className("mod_timetable_change_label")).getText();
            WebElement btnBuyTicket = connection.findElement(By.xpath("//button[@accesskey='1']"));
            String preisWithoutChar = btnBuyTicket.getText().replaceAll("[^\\d.]", "");
            Logger.info(preisWithoutChar);
            double preis = Double.parseDouble(preisWithoutChar.substring(0, preisWithoutChar.length() - 2));
            Logger.info(preis);
            SBBConnection ConnObj = new SBBConnection(richtung, start, end, dauer, umsteigen, preis, btnBuyTicket);
            connections.add(ConnObj);
        }
        return connections;
    }
    public boolean addTicketToCart(String richtung, String start, String end, String dauer) throws Exception{

        for (SBBConnection connection : getAllConnections()) {
            Logger.info(connection.getStart());
            Logger.info(connection.getEnd());
            Logger.info(connection.getDauer());
            Logger.info(connection.getTicketPreis());
            logger.info(connection.getRichtung());
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
    }*/
}
