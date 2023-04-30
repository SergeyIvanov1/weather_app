package com.example.weather.client;

import com.example.weather.entity.WeatherData;
import com.example.weather.exceptions.InvalidParameterException;
import com.example.weather.repositories.WeatherProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherAPICommunicationClient {
    private final RestTemplate restTemplate;
    private String url;

    public WeatherAPICommunicationClient(RestTemplate restTemplate,
                                         WeatherProperties weatherProperties){

        this.restTemplate = restTemplate;
        url = "http://api.weatherapi.com/v1/current.json?key=" + weatherProperties.getApiKey() + "&aqi=" +
                weatherProperties.getAqi() + "&q=";
    }

    public WeatherData getWeatherDataByCoordinates(String coordinates){
        if (coordinates == null){
            throw new InvalidParameterException("Parameter - coordinates is null");
        }

        return restTemplate.getForObject(url + coordinates, WeatherData.class);
    }

}
