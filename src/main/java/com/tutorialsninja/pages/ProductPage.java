package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends Utility {
    By productHPLP3065OnProductPage = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By calendarButtonLink = By.xpath("//div[@class = 'input-group date']//button");
    By daysOfTheMonth = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By nextButton = By.xpath("//div[@class = 'datepicker']/div[@class='datepicker-days']//th[@class='next']");
    By quantityBox = By.id("input-quantity");
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.xpath("/html[1]/body[1]/div[2]/div[1]/a[2]");

    public String getHPLP3065text() {
        return getTextFromElement(productHPLP3065OnProductPage);
    }

    public void selectDate(String inputDay, String inputMonth, String inputYear) {
        clickOnElement(calendarButtonLink);
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String splitMonth = arr[0];
            String splitYear = arr[1];
            if (splitMonth.equalsIgnoreCase(inputMonth) && splitYear.equalsIgnoreCase(inputYear)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = driver.findElements(daysOfTheMonth);
        for (WebElement dateStore : allDates) {
            if (dateStore.getText().equalsIgnoreCase(inputDay)) {
                dateStore.click();
                break;
            }
        }
    }

    public void clearAndAddQuantity(String quantity) {
        driver.findElement(quantityBox).clear();
        sendTextToElement(quantityBox, quantity);
    }

    public void clickAddToCart() {
        clickOnElement(addToCartButton);
    }

    public String isSuccessMessageAppearing() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }
}
