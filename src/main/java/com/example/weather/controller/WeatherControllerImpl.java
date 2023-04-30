package com.example.weather.controller;

import com.example.weather.entity.Weather;
import com.example.weather.entity.WeatherData;
import com.example.weather.services.WeatherService;
import com.sun.net.httpserver.HttpServer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/weather")
public class WeatherControllerImpl {
    private final WeatherService weatherService;

    @RequestMapping("/data")
    public List<Weather> showAllDataByWeather(){
        return weatherService.findAll();
    }

    @GetMapping("/{coordinates}")
    public WeatherData getWeatherByCoordinates(@PathVariable String coordinates){
        return weatherService.getWeatherByCoordinates(coordinates);
    }

    @RequestMapping("/prometheus")
    public void prometheus(){
        PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
            server.createContext("/prometheus", httpExchange -> {
                String response = prometheusRegistry.scrape();
                httpExchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = httpExchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            });

            new Thread(server::start).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
