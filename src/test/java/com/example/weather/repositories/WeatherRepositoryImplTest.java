package com.example.weather.repositories;

import com.example.weather.exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeatherRepositoryImplTest {

    @InjectMocks
    private WeatherRepositoryImpl weatherRepository;


    @Test
    void findAll() {
    }

    @Test
    void save(){
    }

    @Test
    void save_ShouldThrowExceptionIfParameterIsNull() {
        assertThrows(InvalidParameterException.class, () -> weatherRepository.save(null));
    }
}