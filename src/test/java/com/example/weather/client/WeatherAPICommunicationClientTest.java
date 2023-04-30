package com.example.weather.client;

import com.example.weather.exceptions.InvalidParameterException;
import com.example.weather.repositories.WeatherProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeatherAPICommunicationClientTest {

    @InjectMocks
    private WeatherAPICommunicationClient client;
    @Mock
    private WeatherProperties weatherProperties;

    @Test
    void getWeatherDataByCoordinates() {
    }

    @Test
    void getWeatherDataByCoordinates_ShouldThrowExceptionIfParameterIsNull() {
        assertThrows(InvalidParameterException.class,
                () -> client.getWeatherDataByCoordinates(null));
    }
}