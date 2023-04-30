package com.example.weather.repositories;

import com.example.weather.entity.Weather;
import com.example.weather.exceptions.InvalidParameterException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

    private final SessionFactory sessionFactory;

    public WeatherRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Weather> findAll() {
        Session session = sessionFactory.openSession();
        List<Weather> weatherList = session.createQuery("from Weather", Weather.class)
                    .getResultList();
        session.close();
        return weatherList;
    }

    @Override
    public void save(Weather weather) {
        if (weather == null){
            throw new InvalidParameterException("Parameter - weather is null");
        }

        Session session = sessionFactory.openSession();
        session.saveOrUpdate(weather);
        session.close();
    }

}
