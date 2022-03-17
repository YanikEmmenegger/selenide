package ui.pageobjects.sbb;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class SwisspassPage {

    public static final By inputEmail = byId("email");
    public static final By inputPassword = byId("pwd");
    public static final By btnLogin = byId("login_button");
    public static final By checkBoxRememberMe = byId("remember-me");

    public void setEmail(String email){
        $(inputEmail).should(appear).sendKeys(email);
    }
    public void setPassword(String password){
        $(inputPassword).should(appear).sendKeys(password);
    }
    public void setRememberMe(){
        $(checkBoxRememberMe).should(appear).click();
    }
    public void clickLogin(){
        $(btnLogin).should(appear).click();
    }

}
