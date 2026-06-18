package com.beymen.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String filePath = "src/main/resources/config.properties";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e){
            throw new RuntimeException("Konfigürasyon dosyası yüklenemedi: " + e.getMessage());
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
