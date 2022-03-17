package ui.pageobjects.sbb;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OfferPage {
    public static final By btnAddPassenger = byId("buttonAddPassenger");

    public int countPassenger = 0;

    public void setPassengerInfos(String vName, String nName, String bDate, boolean noReduce, boolean halbTax, boolean junior, boolean kid){
        if (countPassenger != 0){
            $(btnAddPassenger).should(appear).click();
        }
        SelenideElement inputVorName = $(byId("passengerLightboxContent2_passengerForm_reisende_"+countPassenger+"_vorname_valueComp"));
        SelenideElement inputName = $(byId("passengerLightboxContent2_passengerForm_reisende_"+countPassenger+"_name_valueComp"));

        inputVorName.should(appear).sendKeys(vName);
        inputName.should(appear).sendKeys(nName);

        countPassenger++;

    }

}
