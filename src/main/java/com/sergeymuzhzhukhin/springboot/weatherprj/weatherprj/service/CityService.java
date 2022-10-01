package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.service;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.City;

import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public interface CityService {
    List<City> getAllCities();
    City getByName(String name);
    City getById(int id);
    void deleteCity(int id);
}
