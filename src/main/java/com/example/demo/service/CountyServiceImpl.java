package com.example.demo.service;

import com.example.demo.Bean.City;
import com.example.demo.Bean.County;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.CountyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyServiceImpl implements CountyService{
    @Autowired
    private CountyMapper countyMapper;


    @Override
    public List<County> getAllCounty() {
        return countyMapper.getAllCounty();
    }

    @Override
    public List<County> getAllCountyByname(String name) {
        System.out.println(name+"Sdf");
        return countyMapper.getAllCountyByname(name);
    }

    @Override
    public void addCounty(County county) {
        countyMapper.addCounty(county);

    }

    @Override
    public List<County> getCountyByid(String id) {
        return countyMapper.getCountyByid(id);
    }
}
