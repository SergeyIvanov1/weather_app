package com.example.weather.services;

import com.example.weather.client.WeatherAPICommunicationClient;
import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;
import com.example.weather.exceptions.GettingWeatherDataException;
import com.example.weather.exceptions.InvalidParameterException;
import com.example.weather.mapper.WeatherMapper;
import com.example.weather.repositories.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherAPICommunicationClient client;
    private final WeatherMapper mapper;

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public WeatherData getWeatherByCoordinates(String coordinates) {
        if (coordinates == null){
            throw new InvalidParameterException("Parameter - coordinates is null ");
        }

        WeatherData weatherData;
        try {
            log.info("Getting weather data");
            weatherData = client.getWeatherDataByCoordinates(coordinates);
        } catch (Exception e) {
            throw new GettingWeatherDataException(e.getMessage());
        }

        Weather weather = mapper.mapToWeather(weatherData);
        weatherRepository.save(weather);

        log.info("Was got a weather data: {}", weatherData);
        return weatherData;
    }

}
