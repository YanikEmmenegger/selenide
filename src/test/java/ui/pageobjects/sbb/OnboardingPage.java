package ui.pageobjects.sbb;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OnboardingPage {

    public static final By btnSwisspassLogin = byId("loginSwisspassButton");
    public static final By btnGuestLogin = byId("loginAsGuestButton");

    public void loginWithSwisspass(){
        $(btnSwisspassLogin).should(appear).click();
    }
    public void loginAsGuest(){
        $(btnGuestLogin).should(appear).click();
    }
}
