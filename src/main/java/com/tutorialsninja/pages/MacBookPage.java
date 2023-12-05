package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class MacBookPage extends Utility {
    By macBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCart = By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");

    public String getTextFromMacBook() {
        return getTextFromElement(macBookText);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    public Boolean isSuccessMessageAppearing() {
        return getTextFromElement(successMessage).contains("Success: You have added MacBook to your shopping cart!");
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }
}
