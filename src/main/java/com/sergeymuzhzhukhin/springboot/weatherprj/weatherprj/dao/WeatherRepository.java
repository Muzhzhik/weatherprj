package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.dao;

import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    void deleteByCityId(int cityId);
}
