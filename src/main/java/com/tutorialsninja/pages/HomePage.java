package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenuListField = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopTab = By.linkText("Desktops");
    By showAllDesktops = By.xpath("//a[normalize-space()='Show AllDesktops']");
    By laptopsAndNoteBooksTab = By.linkText("Laptops & Notebooks");
    By showAllLaptopsAndNotebooks = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");
    By componentsTab = By.linkText("Components");
    By showAllComponents = By.xpath("//a[normalize-space()='Show AllComponents']");
    By myAccounts = By.xpath("//span[contains(text(),'My Account')]");
    By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");
    By loginAccountText = By.xpath("//h2[contains(text(),'Returning Customer')]");

    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            mouseHoverToElement(desktopTab);
            clickOnElement(showAllDesktops);

        } else if (menu == "Laptops & Notebooks") {
            //Find Laptops & Notebooks tab, hover and click on "Show All Laptops & Notebooks"
            mouseHoverToElement(laptopsAndNoteBooksTab);
            clickOnElement(showAllLaptopsAndNotebooks);

        } else if (menu == "Components") {
            //Find Components tab, hover and click on "Show All Components"
            mouseHoverToElement(componentsTab);
            clickOnElement(showAllComponents);

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }
    public void mouseHoverAndClickOnDesktop() {
        selectMenu("Desktops");
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        selectMenu("Laptops & Notebooks");
    }

    public void mouseHoverAndClickOnComponents() {
        selectMenu("Components");
    }

    public void selectMyAccountOptions(String option) {
        //This method should click on the options whatever name is passed as parameter.
        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//list with two options(do multi select)
        for (WebElement option1 : registerList) {
            if (option1.getText().equals(option)) {
                option1.click();
                break;
            }
        }
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccounts);
    }

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public String getLoginAccountText() {
        return getTextFromElement(loginAccountText);
    }
}
