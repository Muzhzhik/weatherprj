package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.dao;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City getCityByNameEquals(String name);
}
