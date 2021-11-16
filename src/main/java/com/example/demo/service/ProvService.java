package com.example.demo.service;

import com.example.demo.Bean.City;
import com.example.demo.Bean.Prov;

import java.util.List;

public interface ProvService {
    List<Prov> getAllProv();
    List<Prov> getAllProvByname(String name);
    void addProv(Prov prov);
    List<Prov> getProvByid(String id);
}
