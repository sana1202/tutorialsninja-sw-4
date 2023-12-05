package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNoteBookPage extends Utility {
    By productsPath = By.xpath("//p[@class ='price']");
    By dropDownPath = By.id("input-sort");
    By laptopAndNoteBookText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By macBookLink = By.linkText("MacBook");
    public String getLaptopAndNoteBookText(){
        return getTextFromElement(laptopAndNoteBookText);
    }

    public ArrayList<Double> getSortByPriceHighToLowSelection() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        // System.out.println(afterSortByPrice)Assert.assertEquals("Product not sorted by price High to Low",
        // originalProductsPrice, afterSortByPrice);
        return afterSortByPrice;
    }

    public ArrayList<String> expectedList() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(productsPath);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }
    public void selectPriceHighToLow(){
        selectByVisibleTextFromDropDown(dropDownPath,"Price (High > Low)");
    }
    public void clickOnMacbook(){
        clickOnElement(macBookLink);
    }
}
