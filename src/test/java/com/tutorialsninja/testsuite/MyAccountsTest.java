package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    AccountCreationPage accountCreationPage = new AccountCreationPage();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(homePage.getRegisterAccountText(), "Register Account", "Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Register Account”.
        Assert.assertEquals(homePage.getLoginAccountText(), "Returning Customer", "Login page not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        Thread.sleep(1000);
        //3.3 Enter First Name
        registerPage.sendFirstName("Jaynika");
        //3.4 Enter Last Name
        registerPage.sendLastName("Patel");
        //3.5 Enter Email
        registerPage.sendEmail("patel");
        //3.6 Enter Telephone
        registerPage.sendTelephone("07654345678");
        //3.7 Enter Password
        registerPage.sendPassword("Hellonum123");
        //3.8 Enter Password Confirm
        registerPage.sendConfirmPassword("Hellonum123");
        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribeToNewsletter();
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
        registerPage.clickOnContinueAfterPrivacyButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountCreationPage.getAccountCreationMessage(), "Your Account Has Been Created!", "account not created");
        //3.13 Click on Continue button
        accountCreationPage.clickOnContinueAfterAccountCreation();
        //3.14 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOption("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "not logged out");
        //3.17 Click on Continue button
        accountPage.clickOnContinueAfterLogout();

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccount();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Login");
        //4.3 enter email
        loginPage.sendEmail("iampatel@gmail.com");
        //enter password
        loginPage.sendPassword("HelloNum1");
        //click login
        loginPage.clickOnLogin();
        //verify if expected equals actual
        Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Not on my account");
        //click my account
        accountPage.clickOnMyAccountLink();
        //choose logout
        homePage.selectMyAccountOptions("Logout");
        //verify if logout has occurred
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "Not logged out");
    }
}
