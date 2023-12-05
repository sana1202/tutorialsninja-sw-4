package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {
    By checkoutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutRadioButton = By.xpath("//div[@id='checkout-checkout']//input[@value='guest']");
    By continueButton = By.xpath("//input[@id='button-account']");
    By continueButtonBillingDetails = By.xpath("//input[@id='button-guest']");
    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postCode = By.id("input-payment-postcode");
    By country = By.id("input-payment-country");
    By regionOrState = By.id("input-payment-zone");
    By commentBox = By.name("comment");
    By termsAndConditionsRadioBox = By.name("agree");
    By continueButtonCommentDetails = By.id("button-payment-method");
    By paymentMethodWarning = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public String getCheckoutText() {
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void clickOnContinueBillingButton() {
        clickOnElement(continueButtonBillingDetails);
    }

    public void clickOnContinueCommentButton() {
        clickOnElement(continueButtonCommentDetails);
    }

    public void enterBillingDetails() throws InterruptedException {
        sendTextToElement(firstName, "Hi");
        sendTextToElement(lastName, "Patel");
        sendTextToElement(email, "Patel"+getRandomAlphaNumericString(4)+"@gmail.com");
        sendTextToElement(telephone, "07654321234");
        sendTextToElement(address, "11 Pinner Road");
        sendTextToElement(city, "Harrow");
        sendTextToElement(postCode, "HA61SY");
        selectByVisibleTextFromDropDown(country, "United Kingdom");
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(regionOrState, "Aberdeen");
    }

    public void enterComment() {
        sendTextToElement(commentBox, "No Comments.");
    }

    public void clickOnAgreeToTermsAndConditions() {
        clickOnElement(termsAndConditionsRadioBox);
    }

    public Boolean isPaymentWarningAppearing() {
        return getTextFromElement(paymentMethodWarning).contains("Warning: Payment method required!");
    }
}
