package com.example.demo.service;

import com.example.demo.Bean.City;
import com.example.demo.Bean.Prov;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.ProvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvServiceImpl implements ProvService{
    @Autowired
    private ProvMapper provMapper;

    @Override
    public List<Prov> getAllProv() {
        return provMapper.getAllProv();
    }

    @Override
    public List<Prov> getAllProvByname(String name) {
        return provMapper.getAllProvByname(name);
    }

    @Override
    public void addProv(Prov prov) {
        provMapper.addProv(prov);

    }

    @Override
    public List<Prov> getProvByid(String id) {
        return provMapper.getProvByid(id);
    }
}
