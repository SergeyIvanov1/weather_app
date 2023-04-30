package com.example.weather.repositories;

import com.example.weather.exceptions.InitDataSourceException;
import com.example.weather.exceptions.InitPropertyException;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
@Component
public class WeatherProperties {

    private String apiKey;
    private String aqi;

    public WeatherProperties() {
        initProperty();
    }

    private void initProperty() {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "app.properties";

            FileInputStream fileInputStream = new FileInputStream(appConfigPath);
            Properties properties = new Properties();
            properties.load(fileInputStream);

            apiKey = properties.getProperty("apiKey");
            aqi = properties.getProperty("aqi");

            fileInputStream.close();
        } catch (IOException e) {
            throw new InitPropertyException(e.getMessage());
        }
    }

}
