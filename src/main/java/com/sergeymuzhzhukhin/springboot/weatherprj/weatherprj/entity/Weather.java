package com.sergeymuzhzhukhin.springboot.weatherprj.weatherprj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Entity
@Table(name="weather")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="city_id", insertable = false, updatable = false)
    private int cityId;

    @Column(name="temp_min")
    private double tempMin;

    @Column(name="temp_max")
    private double tempMax;

    @Column(name="feels_like")
    private double feelsLike;

    @Column(name="pressure")
    private double pressure;

    @Column(name="short_description")
    private String shortDescription;

    @Column(name="long_description")
    private String longDescription;

    @Column(name="visibility")
    private int visibility;

    @Column(name="wind_speed")
    private double windSpeed;

    @Column(name="wdate")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
