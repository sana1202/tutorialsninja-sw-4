package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage extends Utility {
    By myAccountLink = By.xpath("//a[@title='My Account']");

    By continueAfterLogout = By.xpath("//a[@class='btn btn-primary']");
    By myAccountText = By.xpath("//div[@id='content']/h2[text()='My Account']");

    public void selectMyAccountOption(String option){
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    } public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }


    public void clickOnContinueAfterLogout() {
        clickOnElement(continueAfterLogout);
    }

    public String getMyAccountText() {
        return getTextFromElement(myAccountText);
    }
}
