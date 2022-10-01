package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityJ {
    private int id;
    private String base;
    private int visibility;
    private String dt;
    private int timezone;
    private String name;
    private int cod;
    private List<WeatherJ> weather;

    @JsonProperty("main")
    private TemperatureJ temperature;
    private WindJ wind;
    private CloudsJ clouds;
    private SystemJ sys;
    private CoordinatesJ coord;
}
