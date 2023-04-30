package com.example.weather.services;

import com.example.weather.client.WeatherAPICommunicationClient;
import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;
import com.example.weather.exceptions.InvalidParameterException;
import com.example.weather.mapper.WeatherMapper;
import com.example.weather.repositories.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {
    @InjectMocks
    private WeatherServiceImpl weatherService;
    @Mock
    private WeatherRepository weatherRepository;
    @Mock
    private WeatherAPICommunicationClient client;
    @Mock
    private WeatherMapper mapper;
    @Mock
    private Weather weather;

    @Test
    void getWeatherByCoordinates() {
        when(client.getWeatherDataByCoordinates("coordinates")).thenReturn(new WeatherData());
        when(mapper.mapToWeather(any(WeatherData.class))).thenReturn(weather);

        var actual = weatherService.getWeatherByCoordinates("coordinates");
        assertNotNull(actual);

        verify(client, times(1)).getWeatherDataByCoordinates("coordinates");
        verify(weatherRepository, times(1)).save(any(Weather.class));
    }

    @Test
    void findAll() {
        when(weatherRepository.findAll()).thenReturn(new ArrayList<Weather>() {});

        var actual = weatherService.findAll();
        assertNotNull(actual);

        verify(weatherRepository, times(1)).findAll();
    }

    @Test
    void getWeatherByCoordinates_ShouldTrowExceptionIfParameterIsNull() {
        assertThrows(InvalidParameterException.class,
                ()-> weatherService.getWeatherByCoordinates(null));
    }
}