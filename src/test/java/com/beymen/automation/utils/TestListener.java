package com.beymen.automation.utils;

import com.beymen.automation.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("❌ Test Başarısız Oldu: \" + result.getName() + \" -> Ekran görüntüsü alınıyor...");
        if (DriverManager.getDriver() != null) {
            saveScreenshot();
        }
    }

    @Attachment(value = "Hata Anı Ekran Görüntüsü", type = "image/png")
    public byte[] saveScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
