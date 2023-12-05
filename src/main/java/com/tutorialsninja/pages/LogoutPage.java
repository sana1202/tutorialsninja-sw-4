package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LogoutPage extends Utility {
    By logoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

    public String getTextFromLogout() {
        return getTextFromElement(logoutText);
    }
}
