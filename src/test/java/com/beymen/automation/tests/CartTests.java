package com.beymen.automation.tests;

import com.beymen.automation.base.BaseTest;
import com.beymen.automation.pages.CartPage;
import com.beymen.automation.pages.HomePage;
import com.beymen.automation.pages.ProductDetailPage;
import com.beymen.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(description = "Sepete eklenen ürünün kontrolü")
    public void testAddProductToCartAndVerify(){
        HomePage homePage = new HomePage();
        homePage.acceptCookiesAndClosePopups();
        homePage.search("Ayakkabı");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickProductDetail();

        ProductDetailPage productDetailPage = new ProductDetailPage();
        String expectedProductTitle = productDetailPage.getProductTitle();
        productDetailPage.clickAddToCart();

        CartPage cartPage = new CartPage();
        String actualProductTitle = cartPage.getProductTitle();

        Assert.assertEquals(actualProductTitle.trim().toUpperCase(), expectedProductTitle.trim().toUpperCase(),
                "Ürün başlığı eşleşmiyor!");

    }
}
