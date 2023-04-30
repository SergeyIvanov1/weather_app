package com.example.weather.repositories;

import com.example.weather.entity.Weather;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository  {

    List<Weather> findAll();
    void save(Weather weather);
}
