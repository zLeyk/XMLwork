package com.example.demo.service;

import com.example.demo.Bean.City;

import java.util.List;

public interface CityService {
    List<City> getAllCity();
    List<City> getAllCityByname(String name);
    void addCity(City city);
    List<City> getCityByid(String id);
}
