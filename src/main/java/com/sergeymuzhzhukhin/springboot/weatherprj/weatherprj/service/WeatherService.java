package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.service;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.City;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.Weather;

public interface WeatherService {
    Weather getWeather(String city);
    void save(Weather weather);
    void deleteById(int id);
}
