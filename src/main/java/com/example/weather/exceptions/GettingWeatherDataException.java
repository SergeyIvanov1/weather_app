package com.example.weather.exceptions;

public class GettingWeatherDataException extends RuntimeException{
    public GettingWeatherDataException(String message){
        super(message);
    }
}
