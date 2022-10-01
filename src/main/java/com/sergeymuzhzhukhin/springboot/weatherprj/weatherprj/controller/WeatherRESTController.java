package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.controller;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.Weather;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@RestController
@RequestMapping("/weather")
public class WeatherRESTController {

    private final WeatherService weatherService;

    public WeatherRESTController(@Autowired WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public Weather getWeather(@PathVariable String cityName) {
        return weatherService.getWeather(cityName);
    }

    @DeleteMapping("/{cityId}")
    public String delete(@PathVariable int cityId) {
        weatherService.deleteById(cityId);
        return "Delete done";
    }

}
