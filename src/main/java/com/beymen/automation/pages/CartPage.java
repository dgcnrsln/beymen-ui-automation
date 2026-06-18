package com.beymen.automation.pages;

import com.beymen.automation.base.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By productTitle = By.cssSelector(".m-basket__productInfoCategory");

    public String getProductTitle() {
        return readText(productTitle);
    }
}
