package com.beymen.automation.tests;

import com.beymen.automation.base.BaseTest;
import com.beymen.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test(description = "Beymen ana sayfasının başarıyla açıldığının kontrol edilmesi")
    public void testHomePageIsDisplayed(){
        HomePage homePage = new HomePage();
        homePage.acceptCookiesAndClosePopups();

        homePage.isLogoDisplayed();
    }
}
