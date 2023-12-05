package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By productNameText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDateText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By modelText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By totalText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By quantityBox = By.xpath("//div[@class='input-group btn-block']/input[@type='text']");
    By refreshButton = By.xpath("//i[@class = 'fa fa-refresh']");
    By successMessageRefresh = By.xpath("//div[@id='checkout-cart']/div[1]");
    By checkoutButton = By.cssSelector("a.btn.btn-primary");

    public Boolean isShoppingCartAppearing() {
        return getTextFromElement(shoppingCartText).contains("Shopping Cart");
    }

    public String getProductName() {
        return getTextFromElement(productNameText);
    }

    public Boolean isDeliveryDateAppearing() {
        return getTextFromElement(deliveryDateText).contains("2022-11-30");
    }

    public String getModelText() {
        return getTextFromElement(modelText);
    }

    public String getTotalText() {
        return getTextFromElement(totalText);
    }

    public void clearAndAddQuantity(String quantity) {
        driver.findElement(quantityBox).clear();
        sendTextToElement(quantityBox, quantity);
    }

    public void clickOnUpdate() {
        clickOnElement(refreshButton);
    }

    public Boolean isSuccessMessageAppearing() {
        return getTextFromElement(successMessageRefresh).contains("Success: You have modified your shopping cart!");
    }

    public void clickOnCheckout() {
        clickOnElement(checkoutButton);
    }
}
