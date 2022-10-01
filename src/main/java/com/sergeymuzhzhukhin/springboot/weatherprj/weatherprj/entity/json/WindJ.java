package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WindJ {
    private double speed;
    private double deg;
}
