package com.example.demo.mapper;

import com.example.demo.Bean.City;
import com.example.demo.Bean.County;
import com.example.demo.Bean.Prov;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CountyMapper {
    List<County> getAllCounty();
    List<County> getAllCountyByname(String name);
    void addCounty(County county);
    List<County> getCountyByid(String id);
}
