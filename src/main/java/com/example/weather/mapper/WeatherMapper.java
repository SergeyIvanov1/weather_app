package com.example.weather.mapper;

import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    @Mapping(target = "city", source = "weatherData.location.name")
    @Mapping(target = "temperature", source = "weatherData.current.tempC", resultType = String.class)
    @Mapping(target = "condition", source = "weatherData.current.condition.text")
    Weather mapToWeather(WeatherData weatherData);
}
