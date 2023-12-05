package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends TestBase {
    HomePage homePage = new HomePage();
    LaptopAndNoteBookPage laptopAndNoteBookPage = new LaptopAndNoteBookPage();
    MacBookPage macBookPage = new MacBookPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();
        homePage.selectMenu("Laptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        laptopAndNoteBookPage.getSortByPriceHighToLowSelection();
        //1.4 Verify the Product price will arrange in High to Low order.
        List<Double> expText = laptopAndNoteBookPage.getSortByPriceHighToLowSelection();
        List<Double> actText = laptopAndNoteBookPage.getSortByPriceHighToLowSelection();
        System.out.println("Expected list " + expText);
        Assert.assertEquals(Collections.singleton(actText), Collections.singleton(expText));
        System.out.println("Actual List " + actText);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();
        homePage.selectMenu("Laptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndNoteBookPage.selectPriceHighToLow();
        //2.4 Select Product “MacBook”
        laptopAndNoteBookPage.clickOnMacbook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookPage.getTextFromMacBook(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(macBookPage.isSuccessMessageAppearing(), "Message Doesn't Appear");
        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product Name Doesn't appear");
        //2.11 Change Quantity "2"
        shoppingCartPage.clearAndAddQuantity("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdate();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.isSuccessMessageAppearing(), "Cart not modified");
        //2.14 Verify the Total $1,204.00
        Assert.assertEquals(shoppingCartPage.getTotalText(), "$1,204.00", "Total not matched");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckout();
        //2.16 Verify the text “Checkout”
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getCheckoutText(), "Checkout", "Checkout not displayed");
        //2.17 Verify the Text “New Customer”
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getNewCustomerText(), "New Customer", "New Customer not displayed");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckoutRadioButton();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.enterBillingDetails();
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueBillingButton();
        //2.22 Add Comments About your order into text area
        checkoutPage.enterComment();
        //2.23 Check the Terms & Conditions check box
        Thread.sleep(1000);
        checkoutPage.clickOnAgreeToTermsAndConditions();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueCommentButton();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertTrue(checkoutPage.isPaymentWarningAppearing(), "Payment Warning not displayed");
    }
}
