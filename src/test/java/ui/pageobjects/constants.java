package ui.pageobjects;

import com.codeborne.selenide.Configuration;
import org.tinylog.Logger;

import java.awt.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class constants {
    public static final String URL_SBB = "https://sbb.ch";
    public static final String URL_AMZ = "https://amazon.ch";
    public static final String URL_DGT = "https://amazon.ch";

    public void setUp(String URL, String BROWSER){
        Logger.info("---Test Setup Started---");
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.timeout = 5000L;
        Configuration.browser = BROWSER;

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        Configuration.browserSize = width+"x"+height;
        Configuration.browserPosition = "0x0";
        open(URL);
    }


}
