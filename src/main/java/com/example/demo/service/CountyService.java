package com.example.demo.service;

import com.example.demo.Bean.City;
import com.example.demo.Bean.County;

import java.util.List;

public interface CountyService {
    List<County> getAllCounty();
    List<County> getAllCountyByname(String name);
    void addCounty(County county);
    List<County> getCountyByid(String id);
}
