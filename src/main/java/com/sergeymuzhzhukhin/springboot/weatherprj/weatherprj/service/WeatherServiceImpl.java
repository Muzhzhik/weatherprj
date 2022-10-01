package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.dao.CityRepository;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.dao.WeatherRepository;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.City;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.Weather;
import com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.json.CityJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository; // TODO УБРАТЬ КОСТЫЛЬ

    public WeatherServiceImpl(@Autowired WeatherRepository weatherRepository,
                              @Autowired CityRepository cityRepository) {
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Weather getWeather(String cityName) {
        Weather weather = null;
        try {
            ObjectMapper objectMapper = new JsonMapper();
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName
                    + "&APPID=b441f191f452a15d5eda070d46225db6");
            CityJ cityJ = objectMapper.readValue(url, CityJ.class);

            //   TODO --------- КОСТЫЛЬ!!!! ----------
            cityRepository.save(convertCityJToCity(cityJ));
            //----------------------------------------

            weather = convertCityJToWeather(cityJ);
            save(weather);
        } catch (IOException e) {
            // do nothing
        }
        return weather;
    }

    @Override
    public void save(Weather weather) {
        weatherRepository.save(weather);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        weatherRepository.deleteByCityId(id);
    }

    private Weather convertCityJToWeather(CityJ cityJ) {
        return Weather.builder().
                cityId(cityJ.getId()).
                tempMin(cityJ.getTemperature().getTempMin()).
                tempMax(cityJ.getTemperature().getTempMax()).
                feelsLike(cityJ.getTemperature().getFeelsLike()).
                pressure(cityJ.getTemperature().getPressure()).
                shortDescription(cityJ.getWeather().get(0).getMain()).
                longDescription(cityJ.getWeather().get(0).getDescription()).
                visibility(cityJ.getVisibility()).
                windSpeed(cityJ.getWind().getSpeed()).
                date(new Date(System.currentTimeMillis())).
                city(convertCityJToCity(cityJ)).
                build();
    }

    private City convertCityJToCity(CityJ cityJ) {
        return City.builder().
                id(cityJ.getId()).
                name(cityJ.getName()).
                longitude(cityJ.getCoord().getLon()).
                latitude(cityJ.getCoord().getLat()).
                //weather(List.of(weather)).
                        build();
    }
}
