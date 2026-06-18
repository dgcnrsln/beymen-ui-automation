package com.beymen.automation.pages;

import com.beymen.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final By searchField = By.cssSelector(".o-header__search--input");
    private final By searchButton = By.cssSelector(".o-header__search--btn");
    private final By logoImg = By.cssSelector(".o-header__logo");
    private final By acceptCookiesButton = By.cssSelector("#onetrust-button-group #onetrust-reject-all-handler");
    private final By genderPopupClose = By.cssSelector(".o-modal__closeButton.bwi-close");

    public void acceptCookiesAndClosePopups() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // En fazla 2 pop-up gelebileceği için döngüyü 2 kere döndürüyoruz
        for (int i = 0; i < 2; i++) {
            try {
                // Yukarıdaki senin o doğru locator'ların ekrana düşmesini bekle
                shortWait.until(ExpectedConditions.or(
                        ExpectedConditions.elementToBeClickable(acceptCookiesButton),
                        ExpectedConditions.elementToBeClickable(genderPopupClose)
                ));

                // Hangisi o an ekranda aktifse senin tanımladığın locator'lar üzerinden tıkla
                if (!driver.findElements(acceptCookiesButton).isEmpty() && driver.findElement(acceptCookiesButton).isDisplayed()) {
                    driver.findElement(acceptCookiesButton).click();
                } else if (!driver.findElements(genderPopupClose).isEmpty() && driver.findElement(genderPopupClose).isDisplayed()) {
                    driver.findElement(genderPopupClose).click();
                }

                // Sayfanın kendine gelmesi için yarım saniye nefes aldır
                Thread.sleep(500);

            } catch (Exception ignored) {
                // Pop-up'lar kapandıysa veya hiç gelmediyse döngüden çık, vakit kaybetme
                break;
            }
        }
    }

    public void isLogoDisplayed(){
        waitVisible(logoImg);
    }

    public void enterSearchText(String searchText){
        writeText(searchField, searchText);
    }

    public void clickSearchButton(){
        click(searchButton);
    }

    public SearchResultsPage search(String searchText){
        enterSearchText(searchText);
        clickSearchButton();
        return new SearchResultsPage();
    }

}
