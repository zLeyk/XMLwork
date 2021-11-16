package com.example.demo.service;

import com.example.demo.Bean.City;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getAllCity() {
        return cityMapper.getAllCity();
    }

    @Override
    public List<City> getAllCityByname(String name) {
        return cityMapper.getAllCityByname(name);
    }

    @Override
    public void addCity(City city) {
        cityMapper.addCity(city);
    }

    @Override
    public List<City> getCityByid(String id) {
        return cityMapper.getCityByid(id);
    }

}
