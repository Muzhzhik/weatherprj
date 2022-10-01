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
public class SystemJ {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}
