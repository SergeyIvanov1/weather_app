package com.example.weather.services;

import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;

import java.util.List;

public interface WeatherService {

    WeatherData getWeatherByCoordinates(String coordinates);

    List<Weather> findAll();

}
