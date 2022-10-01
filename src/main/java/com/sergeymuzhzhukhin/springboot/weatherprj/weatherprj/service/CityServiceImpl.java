package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.service;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.dao.CityRepository;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    public CityServiceImpl(@Autowired CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getByName(String name) {
        return cityRepository.getCityByNameEquals(name);
    }

    @Override
    public City getById(int id) {
        City city = null;
        Optional<City> optional  = cityRepository.findById(id);
        if (optional.isPresent()) {
            city = optional.get();
        }
        return city;
    }

    @Override
    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }
}
