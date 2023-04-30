package com.example.weather.services;

import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WeatherService {

    @Transactional
    WeatherData getWeatherByCoordinates(String coordinates);

    List<Weather> findAll();

}
