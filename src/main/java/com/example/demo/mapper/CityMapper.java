package com.example.demo.mapper;

import com.example.demo.Bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CityMapper {
    List<City> getAllCity();
    List<City> getAllCityByname(String name);
    void addCity(City city);
    List<City> getCityByid(String id);
}
