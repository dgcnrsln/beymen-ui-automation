package com.beymen.automation.pages;

import com.beymen.automation.base.BasePage;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {

    private final By productTitle = By.cssSelector(".o-productDetail__brandLink");
    private final By productSize = By.xpath("(//div[@class='m-variation']/span[contains(@class, 'm-variation__item')])[1]");
    private final By addToCart = By.id("addBasket");
    private final By goToCartPageButton = By.xpath("//*[contains(text(), 'Sepete Git')]");

    public String getProductTitle(){
        return readText(productTitle);
    }

    public CartPage clickAddToCart(){
        click(productSize);
        click(addToCart);
        click(goToCartPageButton);
        return new CartPage();
    }

}
