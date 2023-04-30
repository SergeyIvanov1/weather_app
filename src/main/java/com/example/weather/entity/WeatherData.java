package com.example.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private Location location;
    private Current current;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location {
        private String name;
        private String region;
        private String country;
        private Double lat;
        private Double lon;
        @JsonProperty("tz_id")
        private String tzId;
        @JsonProperty("localtime_epoch")
        private Integer localtimeEpoch;
        private String localtime;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Current {
        @JsonProperty("last_updated_epoch")
        private Integer lastUpdatedEpoch;
        @JsonProperty("last_updated")
        private String lastUpdated;
        @JsonProperty("temp_c")
        private Double tempC;
        @JsonProperty("temp_f")
        private Double tempF;
        @JsonProperty("is_day")
        private Integer isDay;
        private Condition condition;
        @JsonProperty("wind_mph")
        private Double windMph;
        @JsonProperty("wind_kph")
        private Double windKph;
        @JsonProperty("wind_degree")
        private Integer windDegree;
        @JsonProperty("wind_dir")
        private String windDir;
        @JsonProperty("pressure_mb")
        private Double pressureMb;
        @JsonProperty("pressure_in")
        private Double pressureIn;
        @JsonProperty("precip_mm")
        private Double precipMm;
        @JsonProperty("precip_in")
        private Double precipIn;
        private Integer humidity;
        private Integer cloud;
        @JsonProperty("feelslike_c")
        private Double feelslikeC;
        @JsonProperty("feelslike_f")
        private Double feelslikeF;
        @JsonProperty("vis_km")
        private Double visKm;
        @JsonProperty("vis_miles")
        private Double visMiles;
        private Double uv;
        @JsonProperty("gust_mph")
        private Double gustMph;
        @JsonProperty("gust_kph")
        private Double gustKph;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Condition {
        private String text;
        private String icon;
        private Integer code;
    }
}
