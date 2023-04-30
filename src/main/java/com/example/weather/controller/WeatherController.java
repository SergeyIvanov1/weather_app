package com.example.weather.controller;

import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WeatherController {
    List<Weather> showAllDataByWeather();
    WeatherData getWeatherByCoordinates(@PathVariable String coordinates);
}
