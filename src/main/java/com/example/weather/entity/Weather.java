package com.example.weather.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "weather")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "condition")
    private String condition;

//    public Weather(WeatherData weatherData) {
//        this.city = weatherData.getLocation().getName();
//        this.temperature = String.valueOf(weatherData.getCurrent().getTempC());
//        this.condition = weatherData.getCurrent().getCondition().getText();
//    }
}
