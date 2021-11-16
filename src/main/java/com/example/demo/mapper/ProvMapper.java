package com.example.demo.mapper;

import com.example.demo.Bean.City;
import com.example.demo.Bean.Prov;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProvMapper {
    List<Prov> getAllProv();
    List<Prov> getAllProvByname(String name);
    void addProv(Prov prov);
    List<Prov> getProvByid(String id);
}
