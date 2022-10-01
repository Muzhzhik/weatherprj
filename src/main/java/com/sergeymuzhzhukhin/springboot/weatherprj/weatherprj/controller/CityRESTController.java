package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.controller;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.City;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@RestController
@RequestMapping("/cities")
public class CityRESTController {

    private final CityService cityService;

    public CityRESTController(@Autowired CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/name/{cityName}")
    public City getByName(@PathVariable String cityName) {
        return cityService.getByName(cityName);
    }

    @GetMapping("/id/{cityId}")
    public City getById(@PathVariable int cityId) {
        return cityService.getById(cityId);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
        return "City deleted";
    }
}
