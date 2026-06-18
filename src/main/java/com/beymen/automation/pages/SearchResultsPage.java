package com.beymen.automation.pages;

import com.beymen.automation.base.BasePage;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {

    private final By secondProductCard = By.xpath("(//div[contains(@class, 'o-productList__itemWrapper')])[2]");

    public ProductDetailPage clickProductDetail(){
        click(secondProductCard);
        return new ProductDetailPage();
    }

}
